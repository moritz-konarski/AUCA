/*TODO:
 * add more colors according to recording
 */

#include "aur.hpp"
#include <time.h>

static const float CAMERA_SPEED{0.1f};
static const float CAMERA_ROT_SPEED{0.05f};

static const glm::vec4 COLOR_GREY{0.5f, 0.5f, 0.5f, 1.0f};
static const glm::vec4 COLOR_BLACK{0.0f, 0.0f, 0.0f, 1.0f};
static const glm::vec4 COLOR_RED{1.0f, 0.0f, 0.0f, 1.0f};
static const glm::vec4 BACKGROUND_COLOR{COLOR_BLACK};
static const glm::vec4 SQUARE_COLOR{COLOR_RED};
static const glm::vec4 SPHERE_COLOR{COLOR_RED};
static const glm::vec4 CIRCLE_COLOR{COLOR_RED};
static const glm::vec4 HAND_COLOR{COLOR_RED};

static const int WINDOW_DIMENSIONS{0};
static const int VERTEX_COUNT{30};
static const int SPHERE_RING_COUNT{12};
static const int MESH_TYPE{GL_TRIANGLE_FAN};

static const float CLOCK_RADIUS{1.5f};
static const float LENGTH_HOUR_HAND{0.5f * CLOCK_RADIUS};
static const float LENGTH_MINUTE_HAND{0.75f * CLOCK_RADIUS};
static const float LENGTH_SECOND_HAND{0.95f * CLOCK_RADIUS};
static const float RADIUS_CIRCLE_SMALL{0.02f};
static const float RADIUS_CIRCLE_MEDIUM{0.04f};
static const float SPHERE_RADIUS{RADIUS_CIRCLE_MEDIUM};
static const float SIDE_LENGTH_SQUARE{2.0f * RADIUS_CIRCLE_MEDIUM};
static const float SQUARE_Z_OFFSET{0.05f};
static const float SQUARE_RADIUS_OFFSET{0.1f};
static const float ROT_SPEED_CLOCK{0.005f};

static const glm::vec4 FORWARD{0.0f, 0.0f, 1.0f, 0.0f};


std::shared_ptr<aur::Mesh>
generateSphere(std::shared_ptr<aur::ES2ConstantMaterial> material, const std::string name,
               const float radius,
               const int ringCount);

std::shared_ptr<aur::Mesh> generateClockHand(
        std::shared_ptr<aur::ES2ConstantMaterial> material,
        const std::string name, const float sideA,
        const float sideB);

void generateRingOfSquares(std::shared_ptr<aur::Mesh> mainObject,
                           std::shared_ptr<aur::ES2ConstantMaterial> material,
                           const float mainCircleRadius, const int squareCount,
                           const float sideLengthA, const float sideLengthB);

void generateRingOfCircles(std::shared_ptr<aur::Mesh> mainObject,
                           std::shared_ptr<aur::ES2ConstantMaterial> material,
                           const float mainCircleRadius, const int circleCount,
                           const float circleRadius, const int modulusValue);

void updateHandAngles(struct tm *time_struct, float *secondHandAngle, float *minuteHandAngle,
                      float *hourHandAngle);

void setHandAngle(std::shared_ptr<aur::Mesh> clockHand, float angle, float length);

void rotateY(std::shared_ptr<aur::Mesh> element, float rotationSpeed);

[[noreturn]]
int main(int argc, char **argv) {
    using namespace aur;

    auto window = std::make_shared<SDLWindow>("lab_05_02", WINDOW_DIMENSIONS,
                                              WINDOW_DIMENSIONS);
    auto material = std::make_shared<ES2ConstantMaterial>();

    // sphere in the center
    auto mainSphere = generateSphere(material, "center sphere", SPHERE_RADIUS,
                                     SPHERE_RING_COUNT);
    mainSphere->set_rotation_z(M_PI / 2.0f);

    // small minute marks
    generateRingOfCircles(mainSphere, material, CLOCK_RADIUS, 60,
                          RADIUS_CIRCLE_SMALL, 70);

    // 5 minute marks
    generateRingOfCircles(mainSphere, material, CLOCK_RADIUS, 12,
                          RADIUS_CIRCLE_MEDIUM, 3);

    // 15 minute marks
    generateRingOfSquares(mainSphere, material, CLOCK_RADIUS, 4,
                          SIDE_LENGTH_SQUARE, SIDE_LENGTH_SQUARE);

    // add minute hand
    auto minuteHand = generateClockHand(material, "minute hand",
                                        SIDE_LENGTH_SQUARE / 2.0f,
                                        LENGTH_MINUTE_HAND);
    mainSphere->add_child(minuteHand);

    // add hour hand
    auto hourHand = generateClockHand(material, "hour hand",
                                      SIDE_LENGTH_SQUARE / 1.5f,
                                      LENGTH_HOUR_HAND);
    mainSphere->add_child(hourHand);

    auto secondHand = generateClockHand(material, "second hand",
                                        SIDE_LENGTH_SQUARE / 3.0f,
                                        LENGTH_SECOND_HAND);
    mainSphere->add_child(secondHand);

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

    static float secondHandAngle = 0, minuteHandAngle, hourHandAngle;
    static struct tm *time_struct;

    for (;;) {
        window->poll();

        updateHandAngles(time_struct, &secondHandAngle, &minuteHandAngle, &hourHandAngle);

        rotateY(mainSphere, ROT_SPEED_CLOCK);

        setHandAngle(secondHand, secondHandAngle, LENGTH_SECOND_HAND);
        setHandAngle(minuteHand, minuteHandAngle, LENGTH_MINUTE_HAND);
        setHandAngle(hourHand, hourHandAngle, LENGTH_HOUR_HAND);

        renderer.render();
    }
}

void updateHandAngles(struct tm *time_struct, float *secondHandAngle, float *minuteHandAngle,
                      float *hourHandAngle) {
    time_t t = time(NULL);
    time_struct = localtime(&t);
    *secondHandAngle = -2.0f * M_PI / 60.0f * time_struct->tm_sec;
    *minuteHandAngle = -2.0f * M_PI / 60.0f * time_struct->tm_min;
    *hourHandAngle = -2.0f * M_PI / 12.0f * (time_struct->tm_hour % 12) + *minuteHandAngle / 12.0f;
}

void rotateY(std::shared_ptr<aur::Mesh> element, float rotationSpeed) {
    element->set_rotation_y(element->get_rotation_y() + rotationSpeed);
}

void setHandAngle(std::shared_ptr<aur::Mesh> clockHand, float angle, float length) {
    clockHand->set_x(length / 2.0f * cos(angle));
    clockHand->set_y(length / 2.0f * sin(angle));
    clockHand->set_rotation_z(angle - M_PI / 2.0f);
}

void generateRingOfCircles(std::shared_ptr<aur::Mesh> mainObject,
                           std::shared_ptr<aur::ES2ConstantMaterial> material,
                           const float mainCircleRadius, const int circleCount,
                           const float circleRadius, const int modulusValue) {
    using namespace aur;

    float angle, angleRatio = 2.0f * M_PI / circleCount;

    auto circVert = geometry_generators::generate_circle_geometry_data(
            circleRadius, VERTEX_COUNT, CIRCLE_COLOR);
    auto circGeom = std::make_shared<ES2Geometry>(
            circVert.first, circVert.second);
    circGeom->set_type(MESH_TYPE);
    for (int i = 1; i <= circleCount; ++i) {
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
                           const float sideLengthA, const float sideLengthB) {
    using namespace aur;

    float angle, angleRatio = 2.0f * M_PI / squareCount;

    auto squareVertices = geometry_generators::generate_plane_geometry_data(
            sideLengthA, sideLengthB, VERTEX_COUNT, VERTEX_COUNT, SQUARE_COLOR);
    auto squareGeometry = std::make_shared<ES2Geometry>(
            squareVertices.first, squareVertices.second);
    squareGeometry->set_type(MESH_TYPE);
    for (int i = 1; i <= squareCount; ++i) {
        angle = angleRatio * i;
        auto square = std::make_shared<Mesh>(squareGeometry, material,
                                             glm::vec3{(SQUARE_RADIUS_OFFSET + mainCircleRadius) *
                                                       cos(angle),
                                                       (SQUARE_RADIUS_OFFSET + mainCircleRadius) *
                                                       sin(angle),
                                                       SQUARE_Z_OFFSET});
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
        const float sideB) {

    using namespace aur;

    auto handVertices = geometry_generators::generate_plane_geometry_data(
            sideA, sideB, VERTEX_COUNT, VERTEX_COUNT, HAND_COLOR);
    auto handGeometry = std::make_shared<ES2Geometry>(
            handVertices.first, handVertices.second);
    handGeometry->set_type(MESH_TYPE);
    auto hand = std::make_shared<Mesh>(handGeometry, material,
                                       glm::vec3{0.0f, 0.0f, 0.0f});
    hand->set_name(name);

    return hand;
}

std::shared_ptr<aur::Mesh> generateSphere(
        std::shared_ptr<aur::ES2ConstantMaterial> material,
        const std::string name, const float radius,
        const int ringCount) {

    using namespace aur;

    auto sphereVertices = geometry_generators::generate_sphere_geometry_data(
            radius, VERTEX_COUNT, ringCount, SPHERE_COLOR);
    auto sphereGeometry = std::make_shared<ES2Geometry>(
            sphereVertices.first, sphereVertices.second);
    sphereGeometry->set_type(MESH_TYPE);
    auto sphere = std::make_shared<Mesh>(sphereGeometry, material,
                                         glm::vec3{0.0f, 0.0f, 0.0f});
    sphere->set_name(name);

    return sphere;
}
