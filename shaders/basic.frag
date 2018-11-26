#version 330 core

in vec3 color;
in vec3 fNormal;

void main()
{
    gl_FragColor = vec4(color, 1.0f);
}