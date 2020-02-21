#include "./include/aur.hpp"

static const float CAMERA_SPEED{0.1f};
static const float CAMERA_ROT_SPEED{0.05f};
static const glm::vec3 POSITION = {0.0f, 0.0f, 0.0f};

static const glm::vec4 FORWARD{0.0f, 0.0f, 1.0f, 0.0f};

int main(int argc, char **argv) {
    using namespace aur;

    auto window = std::make_shared<SDLWindow>("lab_05_01", 500, 500);

    auto material = std::make_shared<ES2ConstantMaterial>();

    auto circleVertices = geometry_generators::generate_circle_geometry_data(
            1.0f, 30, glm::vec4 {1.0f, 0.0f, 0.0f, 0.0f});

    auto circleGeometry = std::make_shared<ES2Geometry>(circleVertices.first,
                                                        circleVertices.second);

    auto circle = std::make_shared<Mesh>(circleGeometry, material, POSITION);
    circle->set_name("Circle");
    circle->set_scale(glm::vec3 {1.0f, 1.0f, 1.0f});


    std::vector<std::shared_ptr<Object>> objects{circle};

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
