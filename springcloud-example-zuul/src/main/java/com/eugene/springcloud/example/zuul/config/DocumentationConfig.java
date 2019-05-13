package com.eugene.springcloud.example.zuul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@EnableSwagger2
@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider {

    @Autowired
    ZuulProperties properties;

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();

        properties.getRoutes().values().stream().forEach(route -> {
            resources.add(swaggerResource(route.getId(), route.getPath().replace("**", "v2/api-docs"),"2.0"));
        });
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
