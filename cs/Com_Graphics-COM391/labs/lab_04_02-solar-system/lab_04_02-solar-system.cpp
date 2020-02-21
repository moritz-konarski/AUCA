#include "./include/aur.hpp"

static const float CAMERA_SPEED{0.01f};
static const float CAMERA_ROT_SPEED{0.01f};
// Sun constants
static const float SUN_ROT_SPEED{0.015f};
static const float SUN_RADIUS{0.2f};
static const glm::vec3 SUN_POSITION{glm::vec3{0.0f, 0.0f, 0.0f}};
static const glm::vec4 SUN_COLOR{glm::vec4{1.0f, 1.0f, 0.0f, 0.0f}};
// Earth constants
static const float EARTH_ROT_SPEED{0.05f};
static const float EARTH_RADIUS{0.05f};
static const glm::vec3 EARTH_POSITION{glm::vec3{1.3f, 0.0f, 0.0f}};
static const glm::vec4 EARTH_COLOR{glm::vec4{0.0f, 0.0f, 1.0f, 0.0f}};
// Moon constants
static const float MOON_ROT_SPEED{0.01f};
static const float MOON_RADIUS{0.02f};
static const glm::vec3 MOON_POSITION{glm::vec3{0.3f, 0.0f, 0.0f}};
static const glm::vec4 MOON_COLOR{glm::vec4{0.8f, 0.8f, 0.8f, 0.0f}};
// Mars constants
static const float MARS_ROT_SPEED{0.03f};
static const float MARS_RADIUS{0.04f};
static const glm::vec3 MARS_POSITION{glm::vec3{-2.0f, 0.0f, 0.0f}};
static const glm::vec4 MARS_COLOR{glm::vec4{1.0f, 0.0f, 0.0f, 0.0f}};


static const int VERTEX_COUNT{80};

static const glm::vec4 FORWARD{0.0f, 0.0f, 1.0f, 0.0f};

std::vector<aur::Vertex>
    createCircle(float radius, glm::vec4 color, int vertexCount) {

    std::vector<aur::Vertex> vertices;
    float scale = vertexCount / 2.0;
    for (int i = 0; i < vertexCount; ++i) {
        vertices.push_back(
                aur::Vertex{{radius * cos(M_PI / scale * i),
                                    radius * sin(M_PI / scale * i), 0.0f},
                            {color}});
    }

    return vertices;
}

int main(int argc, char **argv) {
    using namespace aur;

    auto window = std::make_shared<SDLWindow>("lab_04_02-solar-system", 500,
                                              500);

    auto material = std::make_shared<ES2ConstantMaterial>();

    std::vector<Vertex> sunVertices =
            createCircle(SUN_RADIUS, SUN_COLOR, VERTEX_COUNT);
    auto sunGeometry = std::make_shared<ES2Geometry>(sunVertices);
    sunGeometry->set_type(GL_TRIANGLE_FAN);
    auto sun = std::make_shared<Mesh>(sunGeometry, material, SUN_POSITION);
    sun->set_name("Sun");

    std::vector<Vertex> earthVertices =
            createCircle(EARTH_RADIUS, EARTH_COLOR, VERTEX_COUNT);
    auto earthGeometry = std::make_shared<ES2Geometry>(earthVertices);
    earthGeometry->set_type(GL_TRIANGLE_FAN);
    auto earth = std::make_shared<Mesh>(earthGeometry, material,
                                        EARTH_POSITION);
    earth->set_name("Earth");

    std::vector<Vertex> moonVertices =
            createCircle(MOON_RADIUS, MOON_COLOR, VERTEX_COUNT);
    auto moonGeometry = std::make_shared<ES2Geometry>(moonVertices);
    moonGeometry->set_type(GL_TRIANGLE_FAN);
    auto moon = std::make_shared<Mesh>(moonGeometry, material, MOON_POSITION);
    moon->set_name("Moon");

    std::vector<Vertex> marsVertices =
            createCircle(MARS_RADIUS, MARS_COLOR, VERTEX_COUNT);
    auto marsGeometry = std::make_shared<ES2Geometry>(marsVertices);
    marsGeometry->set_type(GL_TRIANGLE_FAN);
    auto mars = std::make_shared<Mesh>(marsGeometry, material, MARS_POSITION);
    mars->set_name("Mars");

    sun->add_child(earth);
    earth->add_child(moon);
    sun->add_child(mars);

    std::vector<std::shared_ptr<Object>> objects{sun};
    auto scene = std::make_shared<Scene>(objects);

    auto &camera = scene->get_camera();
    camera.set_z(5.0f);

    ES2Renderer renderer(scene, window);

    for (;;) {
        SDL_Event event;
        while (SDL_PollEvent(&event)) {
            if (event.type == SDL_QUIT) {
                goto end;
            } else {
                switch (event.key.keysym.sym) {
                    case SDLK_w: {
                        camera.set_rotation_x(
                                camera.get_rotation_x() + CAMERA_ROT_SPEED);
                        break;
                    }
                    case SDLK_a: {
                        camera.set_rotation_y(
                                camera.get_rotation_y() + CAMERA_ROT_SPEED);
                        break;
                    }
                    case SDLK_s: {
                        camera.set_rotation_x(
                                camera.get_rotation_x() - CAMERA_ROT_SPEED);
                        break;
                    }
                    case SDLK_d: {
                        camera.set_rotation_y(
                                camera.get_rotation_y() - CAMERA_ROT_SPEED);
                        break;
                    }
                    case SDLK_e: {
                        camera.set_y(camera.get_y() + CAMERA_ROT_SPEED);
                        break;
                    }
                    case SDLK_q: {
                        camera.set_y(camera.get_y() - CAMERA_ROT_SPEED);
                        break;
                    }
                    case SDLK_UP: {
                        camera.set_position(camera.get_position() - glm::vec3(
                                camera.get_model_matrix() * FORWARD *
                                CAMERA_SPEED));
                        break;
                    }
                    case SDLK_DOWN: {
                        camera.set_position(camera.get_position() + glm::vec3(
                                camera.get_model_matrix() * FORWARD *
                                CAMERA_SPEED));
                        break;
                    }
                }
            }
        }

        sun->set_rotation_z(
                sun->get_rotation_z() + SUN_ROT_SPEED);
        earth->set_rotation_z(
                earth->get_rotation_z() + EARTH_ROT_SPEED);
        moon->set_rotation_z(
                moon->get_rotation_z() + MOON_ROT_SPEED);
        mars->set_rotation_z(
                mars->get_rotation_z() + MARS_ROT_SPEED);

        renderer.render();
    }

    end:
    return 0;
}
