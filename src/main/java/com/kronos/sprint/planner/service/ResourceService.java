package com.kronos.sprint.planner.service;

import com.kronos.sprint.planner.entity.Resource;

import java.util.List;

public interface ResourceService {

    List<Resource> getAllResources();

    List<Resource> getResourcesByTeam(String teamName);

    List<Resource> getResourcesByType(String type);

    List<Resource> saveResource(Resource resource);

    List<Resource> deleteResource(int resourceId);

}
