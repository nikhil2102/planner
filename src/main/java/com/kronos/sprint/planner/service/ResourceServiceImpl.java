package com.kronos.sprint.planner.service;

import com.kronos.sprint.planner.entity.Resource;
import com.kronos.sprint.planner.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    ResourceRepository resourceRepository;

    @Override
    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    @Override
    public List<Resource> getResourcesByTeam(String teamName) {
        return resourceRepository.findResourcesByTeamOrderByName(teamName);
    }

    @Override
    public List<Resource> getResourcesByType(String type) {
        return resourceRepository.findResourcesByTypeOrderByName(type);
    }

    @Override
    public List<Resource> saveResource(Resource resource) {
        resourceRepository.save(resource);
        return getAllResources();
    }

    @Override
    public List<Resource> deleteResource(int resourceId) {
        resourceRepository.deleteById(resourceId);
        return getAllResources();
    }
}
