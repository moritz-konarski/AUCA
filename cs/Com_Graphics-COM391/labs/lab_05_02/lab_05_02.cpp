#include "aur.hpp"

static const float CAMERA_SPEED{0.1f};
static const float CAMERA_ROT_SPEED{0.05f};

static const glm::vec4 COLOR_RED{1.0f, 0.0f, 0.0f, 0.0f};
static const glm::vec4 COLOR_WHITE{1.0f, 1.0f, 1.0f, 1.0f};
static const glm::vec4 COLOR_GREY{0.5f, 0.5f, 0.5f, 0.5f};
static const glm::vec4 BACKGROUND_COLOR{COLOR_GREY};

static const glm::vec3 ORIGIN_POS{0.0f, 0.0f, 0.0f};

static const int WINDOW_DIMENSIONS{0};
static const int VERTEX_COUNT{30};
static const int MESH_TYPE{GL_TRIANGLE_FAN};

static const float RADIUS_CLOCK{1.5f};
static const float LENGTH_HOUR_HAND{0.5f * RADIUS_CLOCK};
static const float LENGTH_MINUTE_HAND{0.75f * RADIUS_CLOCK};
static const float RADIUS_CIRCLE_SMALL{0.02f};
static const float RADIUS_CIRCLE_MEDIUM{0.04f};
static const float SIDE_LENGTH_SQUARE{2.0f * RADIUS_CIRCLE_MEDIUM};
static const float ROT_SPEED_CLOCK{0.02f};
static const float ROT_SPEED_MINUTE_HAND{1.0f / 360.0f};
static const float ROT_SPEED_HOUR_HAND_RATIO{1.0f / 5.0f};

static const glm::vec4 FORWARD{0.0f, 0.0f, 1.0f, 0.0f};

int main(int argc, char **argv) {
    using namespace aur;

    auto window = std::make_shared<SDLWindow>("lab_05_02", WINDOW_DIMENSIONS,
                                              WINDOW_DIMENSIONS);
    //std::vector<std::shared_ptr<Object>> objects;
    auto material = std::make_shared<ES2ConstantMaterial>();

    auto sphereVertices = geometry_generators::generate_sphere_geometry_data(
            RADIUS_CIRCLE_SMALL, VERTEX_COUNT, 12);
    auto sphereGeometry = std::make_shared<ES2Geometry>(
            sphereVertices.first, sphereVertices.second);
    sphereGeometry->set_type(MESH_TYPE);
    auto mainSphere = std::make_shared<Mesh>(sphereGeometry, material,
                                             ORIGIN_POS);
    mainSphere->set_name("center sphere");

    // small minute marks
    auto smallCircleVertices = geometry_generators::generate_circle_geometry_data(
            RADIUS_CIRCLE_SMALL, VERTEX_COUNT);
    auto smallCircleGeometry = std::make_shared<ES2Geometry>(
            smallCircleVertices.first, smallCircleVertices.second);
    smallCircleGeometry->set_type(MESH_TYPE);
    for (int i = 0; i < 60; ++i) {
        if (i % 5 != 0) {
            auto circle = std::make_shared<Mesh>(smallCircleGeometry, material,
                                                 glm::vec3{RADIUS_CLOCK *
                                                           cos(M_PI / 30.0 *
                                                               i),
                                                           RADIUS_CLOCK *
                                                           sin(M_PI / 30.0 *
                                                               i), 0.0f
                                                 });
            char name[20];
            sprintf(name, "small circle %d", i);
            circle->set_name(name);
            mainSphere->add_child(circle);
        }
    }

    // 5 minute marks
    auto circleVertices = geometry_generators::generate_circle_geometry_data(
            RADIUS_CIRCLE_MEDIUM, VERTEX_COUNT);
    auto circleGeometry = std::make_shared<ES2Geometry>(
            circleVertices.first, circleVertices.second);
    circleGeometry->set_type(MESH_TYPE);
    for (int i = 0; i < 12; ++i) {
        if (i % 3 != 0) {
            auto circle = std::make_shared<Mesh>(circleGeometry, material,
                                                 glm::vec3{RADIUS_CLOCK *
                                                           cos(M_PI / 6.0 * i),
                                                           RADIUS_CLOCK *
                                                           sin(M_PI / 6.0 * i),
                                                           0.0f});
            char name[20];
            sprintf(name, "medium circle %d", i);
            circle->set_name(name);
            mainSphere->add_child(circle);
        }
    }

    // 15 minute marks
    auto squareVertices = geometry_generators::generate_plane_geometry_data(
            SIDE_LENGTH_SQUARE, SIDE_LENGTH_SQUARE, VERTEX_COUNT, VERTEX_COUNT);
    auto squareGeometry = std::make_shared<ES2Geometry>(
            squareVertices.first, squareVertices.second);
    squareGeometry->set_type(MESH_TYPE);
    for (int i = 0; i < 4; ++i) {
        auto square = std::make_shared<Mesh>(squareGeometry, material,
                                             glm::vec3{RADIUS_CLOCK *
                                                       cos(M_PI / 2.0 * i),
                                                       RADIUS_CLOCK *
                                                       sin(M_PI / 2.0 * i),
                                                       0.0f});
        char name[20];
        sprintf(name, "square %d", i);
        square->set_rotation_z(M_PI / 4.0f);
        square->set_name(name);
        mainSphere->add_child(square);
    }

    auto hour_sphere = std::make_shared<Mesh>(sphereGeometry, material,
                                              glm::vec3{0.0f,
                                                        LENGTH_HOUR_HAND,
                                                        0.0f});
    hour_sphere->set_name("hour sphere");
    mainSphere->add_child(hour_sphere);

    auto minute_sphere = std::make_shared<Mesh>(sphereGeometry, material,
                                                glm::vec3{0.0f,
                                                          LENGTH_MINUTE_HAND,
                                                          0.0f});
    minute_sphere->set_name("minute sphere");
    //objects.push_back(sphere);
    mainSphere->add_child(minute_sphere);

    std::vector<std::shared_ptr<Object>> clock{mainSphere};

    auto scene = std::make_shared<Scene>(clock);
    scene->set_clear_color(BACKGROUND_COLOR);
    auto root = scene->get_root();

    auto &camera = scene->get_camera();
    camera.set_z(5.0f);

    window->set_on_key([&](int key) {
        switch (key) {
            case SDLK_w:
                camera.set_rotation_x(
                        camera.get_rotation_x() - CAMERA_ROT_SPEED);
                break;
            case SDLK_a:
                camera.set_rotation_y(
                        camera.get_rotation_y() + CAMERA_ROT_SPEED);
                break;
            case SDLK_s:
                camera.set_rotation_x(
                        camera.get_rotation_x() + CAMERA_ROT_SPEED);
                break;
            case SDLK_d:
                camera.set_rotation_y(
                        camera.get_rotation_y() - CAMERA_ROT_SPEED);
                break;
            case SDLK_e:
                camera.set_y(camera.get_y() + CAMERA_ROT_SPEED);
                break;
            case SDLK_q:
                camera.set_y(camera.get_y() - CAMERA_ROT_SPEED);
                break;
            case SDLK_UP:
                camera.set_position(camera.get_position() - glm::vec3(
                        camera.get_model_matrix() * FORWARD * CAMERA_SPEED));
                break;
            case SDLK_DOWN:
                camera.set_position(camera.get_position() + glm::vec3(
                        camera.get_model_matrix() * FORWARD * CAMERA_SPEED));
                break;
            case SDLK_ESCAPE:
                exit(0);
            default:
                break;
        }
    });

    ES2Renderer renderer(scene, window);

    static float angle = M_PI / 2.0f;
    static unsigned int count = 0;
    for (;;) {
        window->poll();

        mainSphere->set_rotation_y(
                mainSphere->get_rotation_y() + ROT_SPEED_CLOCK);

        angle = 2.0 * M_PI * ROT_SPEED_MINUTE_HAND * count;
        ++count;

        minute_sphere->set_position(glm::vec3{LENGTH_MINUTE_HAND * cos(angle),
                                              LENGTH_MINUTE_HAND * sin(angle),
                                              0.0f});
        hour_sphere->set_position(
                glm::vec3{LENGTH_HOUR_HAND *
                          cos(angle * ROT_SPEED_HOUR_HAND_RATIO),
                          LENGTH_HOUR_HAND *
                          sin(angle * ROT_SPEED_HOUR_HAND_RATIO),
                          0.0f});
        // TODO

        renderer.render();
    }
}
