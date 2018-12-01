#version 330 core

in vec3 color;
in vec3 pos;
in vec3 fNormal;

void main()
{
    vec3 light = normalize(vec3(0.2, 0.3, -0.5));
    vec3 normal = normalize(fNormal);

    float diffuse = dot(light, normal);
    float specular = 0;

    vec3 V = normalize(-pos);

    vec3 H = normalize(V + light);

    specular = pow(clamp(dot(normal, H),0, 1), 200);

    diffuse = clamp(diffuse, 0, 1);


    gl_FragColor = vec4(color * diffuse + specular, 1.0);
    //gl_FragColor = vec4(V * 0.5 + 0.5, 1.0f);
}