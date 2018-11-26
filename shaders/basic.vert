#version 330 core

in vec3 position;
in vec3 normal;
uniform mat4 MVP;

out vec3 color;
out vec3 fNormal;

void main()
{
    gl_Position = MVP * vec4(position, 1.0);
    color = normalize(position) / 2 + 0.5;
    fNormal = normal;
}