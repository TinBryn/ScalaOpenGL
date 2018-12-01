#version 330 core

in vec3 position;
in vec3 normal;
uniform mat4 modelView;
uniform mat4 projection;

out vec3 color;
out vec3 fNormal;
out vec3 pos;

void main()
{
    gl_Position = vec4(position, 1.0) * modelView * projection;

    pos = (vec4(position, 1.0) * modelView).xyz;

    mat3 normalMatrix = transpose(inverse(mat3(modelView)));

    fNormal = normal * normalMatrix;
    color = normal * 0.5 + 0.5;
    //color = vec3(1);
}