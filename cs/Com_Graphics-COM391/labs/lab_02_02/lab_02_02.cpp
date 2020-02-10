#define GLM_ENABLE_EXPERIMENTAL

#include <GL/glew.h>
#include <SDL.h>
#include <SDL_opengl.h>
#include <glm/glm.hpp>
#include <glm/gtc/matrix_transform.hpp>
#include <glm/gtc/type_ptr.hpp>
#include <glm/gtx/transform.hpp>

#include <iostream>
#include <glm/gtx/string_cast.hpp>

static int window_width = 500;
static int window_height = 500;

static glm::vec3 triangle_pos = glm::vec3(0, 0, 1);
static glm::vec3 triangle_rot = glm::vec3(0, 0, 0);
static glm::vec3 triangle_sca = glm::vec3(1, 1, 1);

static const float CAMERA_SPEED = 0.01f;
static const float CAMERA_ROT_SPEED = 0.01f;
static glm::vec3 camera_pos = glm::vec3(0, 0, -0.5);
static glm::vec3 camera_rot = glm::vec3(0, M_PI, 0);
static float camera_asp_rat = 1.0f;
static float camera_fov = 1.13f;
static float camera_near_plane = 0.01f;
static float camera_far_plane = 100.0f;

static glm::mat4 triangle_mod_mat;
static glm::mat4 camera_mod_mat;
static glm::mat4 camera_view_mat;
static glm::mat4 camera_proj_mat;
static glm::mat4 triangle_mod_view_proj_mat;

void checkForErrors(const GLubyte *errString, const char *code);

int main(int argc, char **argv) {

    const GLubyte *errString;

    // SDL Setup

    SDL_Init(SDL_INIT_VIDEO);
    SDL_Window *window =
            SDL_CreateWindow(
                    "lab_02_02",
                    SDL_WINDOWPOS_CENTERED, SDL_WINDOWPOS_CENTERED,
                    window_width, window_height,
                    SDL_WINDOW_OPENGL | SDL_WINDOW_ALLOW_HIGHDPI
            );
    SDL_GL_GetDrawableSize(window, &window_width, &window_height);
    SDL_GLContext gl_context = SDL_GL_CreateContext(window);
    glewExperimental = GL_TRUE;
    glewInit();
    SDL_GL_SetSwapInterval(1);

    // OpenGL Shader Compilation

    const char *vertex_shader_source =
        "#version 110\n"                                               \
        "\n"                                                           \
        "attribute vec4 position;\n"                                   \
        "attribute vec4 color;\n"                                      \
        "\n"                                                           \
        "uniform mat4 model_view_projection_matrix;\n"                 \
        "\n"                                                           \
        "varying vec4 fragment_color;\n"                               \
        "\n"                                                           \
        "void main()\n"                                                \
        "{\n"                                                          \
        "    fragment_color = color;\n"                                \
        "\n"                                                           \
        "    gl_Position = model_view_projection_matrix * position;\n" \
        "}";
    const char *fragment_shader_source =
        "#version 110\n"                       \
        "\n"                                   \
        "varying vec4 fragment_color;\n"       \
        "\n"                                   \
        "void main()\n"                        \
        "{\n"                                  \
        "    gl_FragColor = fragment_color;\n" \
        "}";

    GLuint vertex_shader_object = glCreateShader(GL_VERTEX_SHADER);
    glShaderSource(
            vertex_shader_object,
            1, (const GLchar **) &vertex_shader_source, NULL
    );
    glCompileShader(vertex_shader_object);
    GLint status;
    glGetShaderiv(vertex_shader_object, GL_COMPILE_STATUS, &status);
    if (status == GL_FALSE) {
        GLint info_log_length;
        glGetShaderiv(vertex_shader_object, GL_INFO_LOG_LENGTH,
                      &info_log_length);
        if (info_log_length > 0) {
            GLchar *info_log = (GLchar *) malloc((size_t) info_log_length);
            glGetShaderInfoLog(vertex_shader_object, info_log_length, NULL,
                               info_log);
            fprintf(stderr, "Failed to compile a vertex shader\n");
            fprintf(stderr, "Compilation log:\n%s\n\n", info_log);
            free(info_log);
        }
        return -1;
    }

    GLuint fragment_shader_object = glCreateShader(GL_FRAGMENT_SHADER);
    glShaderSource(
            fragment_shader_object,
            1, (const GLchar **) &fragment_shader_source, NULL
    );
    glCompileShader(fragment_shader_object);
    glGetShaderiv(fragment_shader_object, GL_COMPILE_STATUS, &status);
    if (status == GL_FALSE) {
        GLint info_log_length;
        glGetShaderiv(fragment_shader_object, GL_INFO_LOG_LENGTH,
                      &info_log_length);
        if (info_log_length > 0) {
            GLchar *info_log = (GLchar *) malloc((size_t) info_log_length);
            glGetShaderInfoLog(fragment_shader_object, info_log_length, NULL,
                               info_log);
            fprintf(stderr, "Failed to compile a fragment shader\n");
            fprintf(stderr, "Compilation log:\n%s\n\n", info_log);
            free(info_log);
        }
        return -1;
    }

    GLuint shader_program = glCreateProgram();
    glAttachShader(shader_program, vertex_shader_object);
    glAttachShader(shader_program, fragment_shader_object);
    glLinkProgram(shader_program);
    glUseProgram(shader_program);
    glGetProgramiv(shader_program, GL_LINK_STATUS, &status);
    if (status == GL_FALSE) {
        GLint info_log_length;
        glGetProgramiv(shader_program, GL_INFO_LOG_LENGTH, &info_log_length);
        if (info_log_length > 0) {
            GLchar *info_log = (GLchar *) malloc((size_t) info_log_length);
            glGetProgramInfoLog(shader_program, info_log_length, NULL,
                                info_log);
            fprintf(stderr, "Failed to link a GPU program\n");
            fprintf(stderr, "Linker log:\n%s\n\n", info_log);
            free(info_log);
        }

        return -1;
    }
    glDetachShader(shader_program, vertex_shader_object);
    glDetachShader(shader_program, fragment_shader_object);
    glDeleteShader(vertex_shader_object);
    glDeleteShader(fragment_shader_object);

    GLint position_attribute_location =
            glGetAttribLocation(shader_program, "position");
    GLint color_attribute_location =
            glGetAttribLocation(shader_program, "color");
    GLint mvp_matrix_uniform_location =
            glGetUniformLocation(shader_program,
                                 "model_view_projection_matrix");


    // OpengGL Geometry Data Transfer

    GLfloat vertex_data[] = {
            //   Position           Color (RGBA)
            -0.5f, -0.5f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f,
            0.0f, 0.5f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f,
            0.5f, -0.5f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f,
    };

    GLuint vertex_array_object = 0;
    GLuint vertex_buffer_object = 0;
    glGenVertexArrays(1, &vertex_array_object);
    glBindVertexArray(vertex_array_object);
    glGenBuffers(1, &vertex_buffer_object);
    glBindBuffer(GL_ARRAY_BUFFER, vertex_buffer_object);
    glBufferData(
            GL_ARRAY_BUFFER,
            sizeof(vertex_data), vertex_data,
            GL_STATIC_DRAW
    );

    GLsizei stride = sizeof(GLfloat) * 7;
    glEnableVertexAttribArray(position_attribute_location);
    glVertexAttribPointer(
            position_attribute_location,
            3, GL_FLOAT, GL_FALSE, stride, (const GLvoid *) 0
    );
    glEnableVertexAttribArray(color_attribute_location);
    glVertexAttribPointer(
            color_attribute_location,
            4, GL_FLOAT, GL_FALSE, stride,
            (const GLvoid *) (sizeof(GLfloat) * 3)
    );
    glBindVertexArray(0);
    glBindBuffer(GL_ARRAY_BUFFER, 0);

    // OpenGL General Setup

    glClearColor(0, 0, 0, 0);
    glViewport(0, 0, (GLsizei) window_width, (GLsizei) window_height);

    //bool first_time = true;

    checkForErrors(errString, "before loop start, l. 208");

    for (;;) {
        SDL_Event event;
        while (SDL_PollEvent(&event)) {
            if (event.type == SDL_QUIT) {
                goto end;
            } else {
                switch (event.key.keysym.sym) {
                    case SDLK_w:
                        camera_rot.x += CAMERA_ROT_SPEED;
                        break;
                    case SDLK_a:
                        camera_rot.y += CAMERA_ROT_SPEED;
                        break;
                    case SDLK_s:
                        camera_rot.x -= CAMERA_ROT_SPEED;
                        break;
                    case SDLK_d:
                        camera_rot.y -= CAMERA_ROT_SPEED;
                        break;
                    case SDLK_UP: {
                        glm::vec4 dir = glm::vec4(0.0f, 0.0f, 1.0f, 0.0f);
                        dir = camera_mod_mat * dir;
                        dir *= CAMERA_SPEED;

                        camera_pos.x -= dir.x;
                        camera_pos.y -= dir.y;
                        camera_pos.z -= dir.z;
                        break;
                    }
                    case SDLK_DOWN: {
                        glm::vec4 dir = glm::vec4(0.0f, 0.0f, 1.0f, 0.0f);
                        dir = camera_mod_mat * dir;
                        dir *= CAMERA_SPEED;

                        camera_pos.x += dir.x;
                        camera_pos.y += dir.y;
                        camera_pos.z += dir.z;
                        break;
                    }
                }
            }
        }

        // Transformation

        triangle_rot.y += 0.01f;

        triangle_mod_mat = glm::translate(glm::mat4(1.0f),
                                          triangle_pos);
        triangle_mod_mat = glm::rotate(triangle_mod_mat,
                                       triangle_rot.y,
                                       glm::vec3(0, 1, 0));
        triangle_mod_mat = glm::rotate(triangle_mod_mat,
                                       triangle_rot.x,
                                       glm::vec3(1, 0, 0));
        triangle_mod_mat = glm::rotate(triangle_mod_mat,
                                       triangle_rot.z,
                                       glm::vec3(0, 0, 1));
        triangle_mod_mat = glm::scale(triangle_mod_mat,
                                      triangle_sca);

        camera_mod_mat = glm::translate(glm::mat4(1.0f),
                                        camera_pos);
        camera_mod_mat = glm::rotate(camera_mod_mat,
                                     camera_rot.y,
                                     glm::vec3(0, 1, 0));
        camera_mod_mat = glm::rotate(camera_mod_mat,
                                     camera_rot.x,
                                     glm::vec3(1, 0, 0));
        camera_mod_mat = glm::rotate(camera_mod_mat,
                                     camera_rot.z,
                                     glm::vec3(0, 0, 1));
        camera_view_mat = glm::inverse(camera_mod_mat);

        camera_asp_rat = fabsf((float) window_width /
                               (float) window_height);
        camera_proj_mat =
                glm::perspective<float>(
                        camera_fov,
                        camera_asp_rat,
                        camera_near_plane,
                        camera_far_plane
                );

        triangle_mod_view_proj_mat = camera_proj_mat * camera_view_mat *
                triangle_mod_mat;

        /*
        if (first_time) {
            std::cout << glm::to_string(triangle_mod_view_proj_mat)
                      << std::endl;
            first_time = false;
        }
         */

        //checkForErrors(errString, "l. 294");

        glUniformMatrix4fv(
                mvp_matrix_uniform_location,
                1, GL_FALSE,
                glm::value_ptr(triangle_mod_view_proj_mat)
        );

        //checkForErrors(errString, "l. 307");

        glViewport(
                0, 0,
                (GLsizei) window_width,
                (GLsizei) window_height
        );

        // OpenGL Rendering

        glClear(GL_COLOR_BUFFER_BIT);
        glUseProgram(shader_program);
        glBindVertexArray(vertex_array_object);
        glDrawArrays(GL_TRIANGLE_FAN, 0, 3);

        SDL_GL_SwapWindow(window);
    }

    end:
    // SDL cleanup

    SDL_GL_DeleteContext(gl_context);
    SDL_DestroyWindow(window);
    SDL_Quit();

    return 0;
}

void checkForErrors(const GLubyte *errString, const char *code) {
    GLenum errCode;
    while ((errCode = glGetError()) != GL_NO_ERROR) {
        errString = gluErrorString(errCode);
        fprintf(stderr, "OpenGL Error: %s\n", errString);
        fprintf(stderr, "At %s\n", code);
    }
}
