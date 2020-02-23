#include "./include/aur.hpp"

static const float CAMERA_SPEED{0.1f};
static const float CAMERA_ROT_SPEED{0.05f};


static const glm::vec4 COLOR_RED{1.0f, 0.0f, 0.0f, 0.0f};
static const glm::vec4 COLOR_WHITE{1.0f, 1.0f, 1.0f, 1.0f};
static const glm::vec3 POSITION{0.0f, 0.0f, 0.0f};
static const int VERTEX_COUNT{30};
static const float SMALL_RADIUS{0.05f};
static const float MEDIUM_RADIUS{0.08f};


static const glm::vec4 FORWARD{0.0f, 0.0f, 1.0f, 0.0f};

int main(int argc, char **argv) {
    using namespace aur;

    auto window = std::make_shared<SDLWindow>("lab_05_01", 500, 500);

    auto material = std::make_shared<ES2ConstantMaterial>();

    // minute marks
    auto smallCircleVertices = geometry_generators::generate_circle_geometry_data(
            SMALL_RADIUS, VERTEX_COUNT, COLOR_RED);
    auto smallCircleGeometry = std::make_shared<ES2Geometry>(
            smallCircleVertices.first, smallCircleVertices.second);
    std::cout << "Vertex count: " << smallCircleVertices.first.size()
              << std::endl;
    for (auto &i : smallCircleVertices.second) {
        std::cout << "(" << i.position.x << ", " << i.position.y << "), ";
    }
    smallCircleGeometry->set_type(GL_TRIANGLE_STRIP);
    std::vector<std::shared_ptr<Object>> objects;
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
        }
    }

    // 5 minute marks
    auto CircleVertices = geometry_generators::generate_circle_geometry_data(
            MEDIUM_RADIUS, VERTEX_COUNT, COLOR_RED);
    auto CircleGeometry = std::make_shared<ES2Geometry>(
            CircleVertices.first, CircleVertices.second);
    CircleGeometry->set_type(GL_TRIANGLE_STRIP);
    for (int i = 0; i < 12; ++i) {
        auto circle = std::make_shared<Mesh>(CircleGeometry, material,
                                             glm::vec3{cos(M_PI / 6.0 * i),
                                                       sin(M_PI / 6.0 * i),
                                                       0.0f});
        char name[20];
        sprintf(name, "medium circle %d", i);
        circle->set_name(name);
        objects.push_back(circle);
    }

    auto scene = std::make_shared<Scene>(objects);
    scene->set_clear_color(COLOR_WHITE);
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
                break;
            default:
                break;
        }
    });

    ES2Renderer renderer(scene, window);

    for (;;) {
        window->poll();

        // TODO

        renderer.render();
    }
}
