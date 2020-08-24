package com.kronos.sprint.planner.controller;

import com.kronos.sprint.planner.entity.Resource;
import com.kronos.sprint.planner.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ResourceController {

    @Autowired
    ResourceService resourceService;

    @GetMapping("/resources")
    public List<Resource> retrieveAllResources() {
        List<Resource> resources = resourceService.getAllResources();
        return resources;
    }

    @GetMapping("/resources-by-team/{teamName}")
    public List<Resource> retrieveAllResourcesByTeamName(@PathVariable String teamName) {
        return resourceService.getResourcesByTeam(teamName);
    }

    @GetMapping("/resources-by-type/{type}")
    public List<Resource> retrieveAllResourcesByType(@PathVariable String type) {
        return resourceService.getResourcesByType(type);
    }

    @PostMapping("/resource")
    public List<Resource> saveResource(@Valid @RequestBody Resource resource) {
        return resourceService.saveResource(resource);
    }

    @DeleteMapping("/resource/{resourceId}")
    public List<Resource> deleteResource(@PathVariable int resourceId) {
        return resourceService.deleteResource(resourceId);
    }

}
