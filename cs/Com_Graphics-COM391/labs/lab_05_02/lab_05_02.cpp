/*TODO:
 * make the smaller markers floating
 * play with the z values and set stuff to different heights
 * add 60 min markers to all tiles
 * red 15 min quares
 * yellow 5 mins ciicles
 * add hand for seconds
 * make the clock discrete in movement
 * make center point larger
 * add more colors according to recording
 * set to display the correct time
 * factor out code into functions
 */

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
static const int SPHERE_RING_COUNT{12};
static const int MESH_TYPE{GL_TRIANGLE_FAN};

static const float CLOCK_RADIUS{1.5f};
static const float LENGTH_HOUR_HAND{0.5f * CLOCK_RADIUS};
static const float LENGTH_MINUTE_HAND{0.75f * CLOCK_RADIUS};
static const float RADIUS_CIRCLE_SMALL{0.02f};
static const float RADIUS_CIRCLE_MEDIUM{0.04f};
static const float SPHERE_RADIUS{RADIUS_CIRCLE_MEDIUM};
static const float SIDE_LENGTH_SQUARE{2.0f * RADIUS_CIRCLE_MEDIUM};
static const float ROT_SPEED_CLOCK{0.01f};
static const float ROT_SPEED_MINUTE_HAND{-1.0f / 360.0f};
static const float ROT_SPEED_HOUR_HAND_RATIO{1.0f / 6.0f};

static const glm::vec4 FORWARD{0.0f, 0.0f, 1.0f, 0.0f};

void generateRingOfCircles(std::shared_ptr<aur::Mesh> mainObject,
                           std::shared_ptr<aur::ES2ConstantMaterial> material,
                           const float mainCircleRadius, const int circleCount,
                           const float circleRadius, const int modulusValue,
                           const int vertexCount,
                           const int meshType) {
    using namespace aur;

    float angle, angleRatio = 2.0f * M_PI / circleCount;

    auto circVert = geometry_generators::generate_circle_geometry_data(
            circleRadius, vertexCount);
    auto circGeom = std::make_shared<ES2Geometry>(
            circVert.first, circVert.second);
    circGeom->set_type(meshType);
    for (int i = 0; i < circleCount; ++i) {
        if (i % modulusValue != 0) {
            angle = angleRatio * i;
            auto circle = std::make_shared<Mesh>(circGeom, material,
                                                 glm::vec3{mainCircleRadius *
                                                           cos(angle),
                                                           mainCircleRadius *
                                                           sin(angle), 0.0f
                                                 });
            char name[15];
            sprintf(name, "circle %d", i);
            circle->set_name(name);
            mainObject->add_child(circle);
        }
    }
}

void generateRingOfSquares(std::shared_ptr<aur::Mesh> mainObject,
                           std::shared_ptr<aur::ES2ConstantMaterial> material,
                           const float mainCircleRadius, const int squareCount,
                           const float sideLengthA, const float sideLengthB,
                           const int vertexCount,
                           const int meshType) {
    using namespace aur;

    float angle, angleRatio = 2.0f * M_PI / squareCount;

    auto squareVertices = geometry_generators::generate_plane_geometry_data(
            sideLengthA, sideLengthB, vertexCount, vertexCount);
    auto squareGeometry = std::make_shared<ES2Geometry>(
            squareVertices.first, squareVertices.second);
    squareGeometry->set_type(meshType);
    for (int i = 0; i < squareCount; ++i) {
        angle = angleRatio * i;
        auto square = std::make_shared<Mesh>(squareGeometry, material,
                                             glm::vec3{mainCircleRadius *
                                                       cos(angle),
                                                       mainCircleRadius *
                                                       sin(angle),
                                                       0.0f});
        char name[15];
        sprintf(name, "square %d", i);
        square->set_rotation_z(M_PI / 4.0f);
        square->set_name(name);
        mainObject->add_child(square);
    }


}

std::shared_ptr<aur::Mesh> generateClockHand(
        std::shared_ptr<aur::ES2ConstantMaterial> material,
        const std::string name, const float sideA,
        const float sideB,
        const int vertexCount, const int meshType) {

    using namespace aur;

    auto handVertices = geometry_generators::generate_plane_geometry_data(
            sideA, sideB, vertexCount, vertexCount);
    auto handGeometry = std::make_shared<ES2Geometry>(
            handVertices.first, handVertices.second);
    handGeometry->set_type(meshType);
    auto hand = std::make_shared<Mesh>(handGeometry, material,
                                       glm::vec3{0.0f, 0.0f, 0.0f});
    hand->set_name(name);

    return hand;
}

std::shared_ptr<aur::Mesh> generateSphere(
        std::shared_ptr<aur::ES2ConstantMaterial> material,
        const std::string name, const float radius,
        const int ringCount,
        const int vertexCount, const int meshType) {

    using namespace aur;

    auto sphereVertices = geometry_generators::generate_sphere_geometry_data(
            radius, vertexCount, ringCount);
    auto sphereGeometry = std::make_shared<ES2Geometry>(
            sphereVertices.first, sphereVertices.second);
    sphereGeometry->
            set_type(meshType);
    auto sphere = std::make_shared<Mesh>(sphereGeometry, material,
                                         glm::vec3{0.0f, 0.0f, 0.0f});
    sphere->set_name(name);

    return sphere;
}


[[noreturn]]
int main(int argc, char **argv) {
    using namespace aur;

    auto window = std::make_shared<SDLWindow>("lab_05_02", WINDOW_DIMENSIONS,
                                              WINDOW_DIMENSIONS);
    auto material = std::make_shared<ES2ConstantMaterial>();

    // sphere in the center
    auto mainSphere = generateSphere(material, "center sphere", SPHERE_RADIUS,
                                     SPHERE_RING_COUNT, VERTEX_COUNT,
                                     MESH_TYPE);
    mainSphere->set_rotation_z(M_PI / 2.0f);

    // small minute marks
    generateRingOfCircles(mainSphere, material, CLOCK_RADIUS, 60,
                          RADIUS_CIRCLE_SMALL, 60, VERTEX_COUNT, MESH_TYPE);

    // 5 minute marks
    generateRingOfCircles(mainSphere, material, CLOCK_RADIUS + 0.05f, 12,
                          RADIUS_CIRCLE_MEDIUM, 3, VERTEX_COUNT, MESH_TYPE);

    // 15 minute marks
    generateRingOfSquares(mainSphere, material, CLOCK_RADIUS + 0.05f, 4,
                          SIDE_LENGTH_SQUARE, SIDE_LENGTH_SQUARE, VERTEX_COUNT,
                          MESH_TYPE);

    // add minute hand
    auto minuteHand = generateClockHand(material, "minute hand",
                                        SIDE_LENGTH_SQUARE / 2.0f,
                                        LENGTH_MINUTE_HAND, VERTEX_COUNT,
                                        MESH_TYPE);
    mainSphere->add_child(minuteHand);

    // add hour hand
    auto hourHand = generateClockHand(material, "hour hand",
                                      SIDE_LENGTH_SQUARE / 1.5f,
                                      LENGTH_HOUR_HAND, VERTEX_COUNT,
                                      MESH_TYPE);
    mainSphere->add_child(hourHand);

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

    static float angle = 0;
    static unsigned int count = 0;

    for (;;) {
        window->poll();

        mainSphere->set_rotation_y(
                mainSphere->get_rotation_y() + ROT_SPEED_CLOCK);

        angle = 2.0 * M_PI * ROT_SPEED_MINUTE_HAND * count;
        ++count;

        minuteHand->set_position(
                glm::vec3{LENGTH_MINUTE_HAND / 2.0f * cos(angle),
                          LENGTH_MINUTE_HAND / 2.0f * sin(angle),
                          0.0f});
        minuteHand->set_rotation_z(angle - M_PI / 2.0f);


        hourHand->set_position(
                glm::vec3{LENGTH_HOUR_HAND / 2.0f *
                          cos(angle * ROT_SPEED_HOUR_HAND_RATIO),
                          LENGTH_HOUR_HAND / 2.0f *
                          sin(angle * ROT_SPEED_HOUR_HAND_RATIO),
                          0.0f});
        hourHand->set_rotation_z(
                angle * ROT_SPEED_HOUR_HAND_RATIO - M_PI / 2.0f);

        renderer.render();
    }
}
