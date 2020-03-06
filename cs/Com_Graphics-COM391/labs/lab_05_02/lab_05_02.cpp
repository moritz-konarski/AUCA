#include "aur.hpp"
#include <time.h>

static const float SPEED_CAMERA{0.1f};
static const float ROTATION_SPEED_CAMERA{0.05f};

static const glm::vec3 POSITION_ORIGIN{0.0f, 0.0f, 0.0f};
static const glm::vec3 POSITION_OFFSET_SQUARES{0.0f, 0.0f, 0.05f};
static const glm::vec3 POSITION_OFFSET_MEDIUM_CIRCLES{0.0f, 0.0f, -0.05f};

static const glm::vec4 COLOR_BLUE{0.0f, 0.0f, 1.0f, 1.0f};
static const glm::vec4 COLOR_BLACK{0.0f, 0.0f, 0.0f, 1.0f};
static const glm::vec4 COLOR_RED{1.0f, 0.0f, 0.0f, 1.0f};
static const glm::vec4 COLOR_BACKGROUND{COLOR_BLACK};
static const glm::vec4 COLOR_SQUARE{COLOR_BLUE};
static const glm::vec4 COLOR_MAIN_SPHERE{COLOR_RED};
static const glm::vec4 COLOR_SMALL_CIRCLE{COLOR_RED};
static const glm::vec4 COLOR_MEDIUM_CIRCLE{COLOR_RED};
static const glm::vec4 COLOR_SECOND_HAND{COLOR_BLUE};
static const glm::vec4 COLOR_MINUTE_HAND{COLOR_RED};
static const glm::vec4 COLOR_HOUR_HAND{COLOR_RED};

static const int MESH_TYPE{GL_TRIANGLE_FAN};
static const int WINDOW_DIMENSIONS{0};
static const int COUNT_VERTEX{30};
static const int COUNT_SPHERE_RING{12};
static const int COUNT_SMALL_CIRCLES{60};
static const int COUNT_MEDIUM_CIRCLES{12};
static const int COUNT_SQUARES{4};

static const int MODULUS_SMALL_CIRCLES{COUNT_SMALL_CIRCLES + 1};
static const int MODULUS_MEDIUM_CIRCLES{COUNT_MEDIUM_CIRCLES / COUNT_SQUARES};

static const float RADIUS_CLOCK{1.5f};
static const float RADIUS_CIRCLE_SMALL{0.02f};
static const float RADIUS_CIRCLE_MEDIUM{0.04f};
static const float RADIUS_MAIN_SPHERE{RADIUS_CIRCLE_MEDIUM};
static const float LENGTH_SQUARE_SIDE{2.0f * RADIUS_CIRCLE_MEDIUM};
static const float LENGTH_HOUR_HAND{0.5f * RADIUS_CLOCK};
static const float LENGTH_MINUTE_HAND{0.75f * RADIUS_CLOCK};
static const float LENGTH_SECOND_HAND{0.95f * RADIUS_CLOCK};
static const float WIDTH_SECOND_HAND{LENGTH_SQUARE_SIDE / 3.0f};
static const float WIDTH_MINUTE_HAND{LENGTH_SQUARE_SIDE / 2.0f};
static const float WIDTH_HOUR_HAND{LENGTH_SQUARE_SIDE / 1.5f};
static const float RADIUS_OFFSET_SQUARE{0.1f};
static const float Y_ROTATION_SPEED_CLOCK{0.002f};

static const glm::vec4 FORWARD{0.0f, 0.0f, 1.0f, 0.0f};

std::shared_ptr<aur::Mesh>
generateSphere(std::shared_ptr<aur::ES2ConstantMaterial> material, const std::string name,
               const float radius,
               const int ringCount, glm::vec4 color, glm::vec3 position);

std::shared_ptr<aur::Mesh> generateClockHand(
        std::shared_ptr<aur::ES2ConstantMaterial> material,
        const std::string name, const float sideA,
        const float sideB, glm::vec4 color, glm::vec3 position);

void generateRingOfSquares(std::shared_ptr<aur::Mesh> mainObject,
                           std::shared_ptr<aur::ES2ConstantMaterial> material,
                           const float mainCircleRadius, const int squareCount,
                           const float sideLengthA, const float sideLengthB, glm::vec4 color,
                           glm::vec3 position);

void generateRingOfCircles(std::shared_ptr<aur::Mesh> mainObject,
                           std::shared_ptr<aur::ES2ConstantMaterial> material,
                           const float mainCircleRadius, const int circleCount,
                           const float circleRadius, const int modulusValue, glm::vec4 color,
                           glm::vec3 position);

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
    auto mainSphere = generateSphere(material, "center sphere", RADIUS_MAIN_SPHERE,
                                     COUNT_SPHERE_RING, COLOR_MAIN_SPHERE, POSITION_ORIGIN);
    // rotate sphere so 0 degrees is straight up
    mainSphere->set_rotation_z(M_PI / 2.0f);

    // small minute marks
    generateRingOfCircles(mainSphere, material, RADIUS_CLOCK, COUNT_SMALL_CIRCLES,
                          RADIUS_CIRCLE_SMALL, MODULUS_SMALL_CIRCLES, COLOR_SMALL_CIRCLE,
                          POSITION_ORIGIN);

    // 5 minute marks
    generateRingOfCircles(mainSphere, material, RADIUS_CLOCK, COUNT_MEDIUM_CIRCLES,
                          RADIUS_CIRCLE_MEDIUM, MODULUS_MEDIUM_CIRCLES, COLOR_MEDIUM_CIRCLE,
                          POSITION_OFFSET_MEDIUM_CIRCLES);

    // 15 minute marks
    generateRingOfSquares(mainSphere, material, RADIUS_CLOCK, COUNT_SQUARES,
                          LENGTH_SQUARE_SIDE, LENGTH_SQUARE_SIDE, COLOR_SQUARE,
                          POSITION_OFFSET_SQUARES);

    // add second hand
    auto secondHand = generateClockHand(material, "second hand",
                                        WIDTH_SECOND_HAND,
                                        LENGTH_SECOND_HAND, COLOR_SECOND_HAND, POSITION_ORIGIN);
    mainSphere->add_child(secondHand);

    // add minute hand
    auto minuteHand = generateClockHand(material, "minute hand",
                                        WIDTH_MINUTE_HAND,
                                        LENGTH_MINUTE_HAND, COLOR_MINUTE_HAND, POSITION_ORIGIN);
    mainSphere->add_child(minuteHand);

    // add hour hand
    auto hourHand = generateClockHand(material, "hour hand",
                                      WIDTH_HOUR_HAND,
                                      LENGTH_HOUR_HAND, COLOR_HOUR_HAND, POSITION_ORIGIN);
    mainSphere->add_child(hourHand);

    std::vector<std::shared_ptr<Object>> clock{mainSphere};

    auto scene = std::make_shared<Scene>(clock);
    scene->set_clear_color(COLOR_BACKGROUND);
    auto root = scene->get_root();

    auto &camera = scene->get_camera();
    camera.set_z(5.0f);

    window->set_on_key([&](int key) {
        switch (key) {
            case SDLK_w:
                camera.set_rotation_x(
                        camera.get_rotation_x() - ROTATION_SPEED_CAMERA);
                break;
            case SDLK_a:
                camera.set_rotation_y(
                        camera.get_rotation_y() + ROTATION_SPEED_CAMERA);
                break;
            case SDLK_s:
                camera.set_rotation_x(
                        camera.get_rotation_x() + ROTATION_SPEED_CAMERA);
                break;
            case SDLK_d:
                camera.set_rotation_y(
                        camera.get_rotation_y() - ROTATION_SPEED_CAMERA);
                break;
            case SDLK_e:
                camera.set_y(camera.get_y() + ROTATION_SPEED_CAMERA);
                break;
            case SDLK_q:
                camera.set_y(camera.get_y() - ROTATION_SPEED_CAMERA);
                break;
            case SDLK_UP:
                camera.set_position(camera.get_position() - glm::vec3(
                        camera.get_model_matrix() * FORWARD * SPEED_CAMERA));
                break;
            case SDLK_DOWN:
                camera.set_position(camera.get_position() + glm::vec3(
                        camera.get_model_matrix() * FORWARD * SPEED_CAMERA));
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

        rotateY(mainSphere, Y_ROTATION_SPEED_CLOCK);

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
    *secondHandAngle = -2.0f * M_PI/ 60.0f * time_struct->tm_sec;
    *minuteHandAngle = -2.0f * M_PI/ 60.0f * time_struct->tm_min;
    *hourHandAngle = -2.0f * M_PI/ 12.0f * (time_struct->tm_hour % 12) + *minuteHandAngle / 12.0f;
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
                           const float circleRadius, const int modulusValue, glm::vec4 color,
                           glm::vec3 position) {
    using namespace aur;

    float angle, angleRatio = 2.0f * M_PI/ circleCount;

    auto circVert = geometry_generators::generate_circle_geometry_data(
            circleRadius, COUNT_VERTEX, color);
    auto circGeom = std::make_shared<ES2Geometry>(
            circVert.first, circVert.second);
    circGeom->set_type(MESH_TYPE);
    for (int i = 1; i <= circleCount; ++i) {
        if (i % modulusValue != 0) {
            angle = angleRatio * i;
            auto circle = std::make_shared<Mesh>(circGeom, material,
                                                 glm::vec3{mainCircleRadius *
                                                           cos(angle) + position.x,
                                                           mainCircleRadius *
                                                           sin(angle) + position.y,
                                                           position.z
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
                           const float sideLengthA, const float sideLengthB, glm::vec4 color,
                           glm::vec3 position) {
    using namespace aur;

    float angle, angleRatio = 2.0f * M_PI/ squareCount;

    auto squareVertices = geometry_generators::generate_plane_geometry_data(
            sideLengthA, sideLengthB, COUNT_VERTEX, COUNT_VERTEX, color);
    auto squareGeometry = std::make_shared<ES2Geometry>(
            squareVertices.first, squareVertices.second);
    squareGeometry->set_type(MESH_TYPE);
    for (int i = 1; i <= squareCount; ++i) {
        angle = angleRatio * i;
        auto square = std::make_shared<Mesh>(squareGeometry, material,
                                             glm::vec3{(RADIUS_OFFSET_SQUARE + mainCircleRadius) *
                                                       cos(angle) + position.x,
                                                       (RADIUS_OFFSET_SQUARE + mainCircleRadius) *
                                                       sin(angle) + position.y,
                                                       position.z});
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
        const float sideB, glm::vec4 color, glm::vec3 position) {

    using namespace aur;

    auto handVertices = geometry_generators::generate_plane_geometry_data(
            sideA, sideB, COUNT_VERTEX, COUNT_VERTEX, color);
    auto handGeometry = std::make_shared<ES2Geometry>(
            handVertices.first, handVertices.second);
    handGeometry->set_type(MESH_TYPE);
    auto hand = std::make_shared<Mesh>(handGeometry, material, position);
    hand->set_name(name);

    return hand;
}

std::shared_ptr<aur::Mesh> generateSphere(
        std::shared_ptr<aur::ES2ConstantMaterial> material,
        const std::string name, const float radius,
        const int ringCount, glm::vec4 color, glm::vec3 position) {

    using namespace aur;

    auto sphereVertices = geometry_generators::generate_sphere_geometry_data(
            radius, COUNT_VERTEX, ringCount, color);
    auto sphereGeometry = std::make_shared<ES2Geometry>(
            sphereVertices.first, sphereVertices.second);
    sphereGeometry->set_type(MESH_TYPE);
    auto sphere = std::make_shared<Mesh>(sphereGeometry, material, position);
    sphere->set_name(name);

    return sphere;
}
