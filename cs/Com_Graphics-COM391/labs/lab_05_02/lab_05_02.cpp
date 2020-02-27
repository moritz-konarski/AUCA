#include "aur.hpp"

static const float CAMERA_SPEED{0.1f};
static const float CAMERA_ROT_SPEED{0.05f};

static const glm::vec4 COLOR_RED{1.0f, 0.0f, 0.0f, 0.0f};
static const glm::vec4 COLOR_WHITE{1.0f, 1.0f, 1.0f, 1.0f};
static const glm::vec3 POSITION{0.0f, 0.0f, 0.0f};
static const int VERTEX_COUNT{30};
static const float SMALL_RADIUS{0.02f};
static const float MEDIUM_RADIUS{0.04f};
static const float SQUARE_SIDE_LENGTH{0.08f};
static const float ROTATION_SPEED{0.5f};

static const glm::vec4 FORWARD{0.0f, 0.0f, 1.0f, 0.0f};

int main(int argc, char **argv) {
    using namespace aur;

    auto window = std::make_shared<SDLWindow>("lab_05_02", 500, 500);
    std::vector<std::shared_ptr<Object>> objects;
    auto material = std::make_shared<ES2ConstantMaterial>();

    auto sphereVertices = geometry_generators::generate_sphere_geometry_data(
            SMALL_RADIUS, VERTEX_COUNT, 12);
    auto sphereGeometry = std::make_shared<ES2Geometry>(
            sphereVertices.first, sphereVertices.second);
    sphereGeometry->set_type(GL_TRIANGLE_FAN);
    auto mainSphere = std::make_shared<Mesh>(sphereGeometry, material,
                                             glm::vec3{0.0f, 0.0f, 0.0f});
    mainSphere->set_name("center sphere");
    objects.push_back(mainSphere);

    // small minute marks
    auto smallCircleVertices = geometry_generators::generate_circle_geometry_data(
            SMALL_RADIUS, VERTEX_COUNT);
    auto smallCircleGeometry = std::make_shared<ES2Geometry>(
            smallCircleVertices.first, smallCircleVertices.second);
    smallCircleGeometry->set_type(GL_TRIANGLE_STRIP);
    for (int i = 0; i < 60; ++i) {
        if (i % 5 != 0) {
            auto circle = std::make_shared<Mesh>(smallCircleGeometry, material,
                                                 glm::vec3{cos(M_PI / 30.0 * i),
                                                           sin(M_PI / 30.0 * i),
                                                           0.0f});
            char name[20];
            sprintf(name, "small circle %d", i);
            circle->set_name(name);
            objects.push_back(circle);
            mainSphere->add_child(circle);
        }
    }

    // 5 minute marks
    auto circleVertices = geometry_generators::generate_circle_geometry_data(
            MEDIUM_RADIUS, VERTEX_COUNT);
    auto circleGeometry = std::make_shared<ES2Geometry>(
            circleVertices.first, circleVertices.second);
    circleGeometry->set_type(GL_TRIANGLE_STRIP);
    for (int i = 0; i < 12; ++i) {
        if (i % 3 != 0) {
            auto circle = std::make_shared<Mesh>(circleGeometry, material,
                                                 glm::vec3{cos(M_PI / 6.0 * i),
                                                           sin(M_PI / 6.0 * i),
                                                           0.0f});
            char name[20];
            sprintf(name, "medium circle %d", i);
            circle->set_name(name);
            objects.push_back(circle);
            mainSphere->add_child(circle);
        }
    }

    // 15 minute marks
    auto squareVertices = geometry_generators::generate_plane_geometry_data(
            SQUARE_SIDE_LENGTH, SQUARE_SIDE_LENGTH, VERTEX_COUNT, VERTEX_COUNT);
    auto squareGeometry = std::make_shared<ES2Geometry>(
            squareVertices.first, squareVertices.second);
    squareGeometry->set_type(GL_TRIANGLE_STRIP);
    for (int i = 0; i < 4; ++i) {
        auto square = std::make_shared<Mesh>(squareGeometry, material,
                                             glm::vec3{cos(M_PI / 2.0 * i),
                                                       sin(M_PI / 2.0 * i),
                                                       0.0f});
        char name[20];
        sprintf(name, "square %d", i);
        square->set_name(name);
        objects.push_back(square);
        mainSphere->add_child(square);
    }

    auto sphere = std::make_shared<Mesh>(sphereGeometry, material,
                                         glm::vec3{0.5f, 0.0f, 0.0f});
    sphere->set_name("one sphere");
    objects.push_back(sphere);
    mainSphere->add_child(sphere);

    sphere = std::make_shared<Mesh>(sphereGeometry, material,
                                    glm::vec3{-0.5f, 0.0f, 0.0f});
    sphere->set_name("two sphere");
    objects.push_back(sphere);
    mainSphere->add_child(sphere);






    // TODO
    auto scene = std::make_shared<Scene>(objects);
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

    for (;;) {
        window->poll();

        mainSphere->set_rotation_z(
                mainSphere->get_rotation_z() + ROTATION_SPEED);
        mainSphere->set_rotation_x(
                mainSphere->get_rotation_x() + ROTATION_SPEED);
        mainSphere->set_rotation_y(
                mainSphere->get_rotation_y() + ROTATION_SPEED);
        // TODO

        renderer.render();
    }
}
