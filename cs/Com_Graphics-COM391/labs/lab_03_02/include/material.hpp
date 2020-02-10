#ifndef MATERIAL_HPP
#define MATERIAL_HPP

#include "shader.hpp"

#include <memory>

#include <glm/glm.hpp>

class Material {
public:
    const Shader &get_shader() const {
        return *_shader;
    }

    virtual ~Material() = default;

    virtual void update(glm::mat4 &mvp_matrix) = 0;

    virtual void use() = 0;

protected:
    std::shared_ptr<Shader> _shader;
};

#endif
