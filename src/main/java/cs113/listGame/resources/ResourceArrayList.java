package cs113.listGame.resources;

import cs113.listGame.gamecore.GameObject;

import java.util.ArrayList;
import java.util.List;

public class ResourceArrayList implements ResourceList {
    List resourceList = new ArrayList<>();
    @Override
    public void add(ResourceObject resource) {
        resourceList.add(resource);
    }

    @Override
    public void remove(ResourceObject resource) {
        resourceList.remove(resource);
    }

    @Override
    public void truncate(ResourceObject resource) {
        int resourceNum = resourceList.indexOf(resource);

        if(resourceNum != -1) {
            for (int i = resourceNum; i < resourceList.size(); i++) {
                resourceList.remove(resourceNum);
            }
        }


       /*if(resourceNum > -1) {
            while (resourceList.get(resourceNum) != null && resourceNum < resourceList.size()) {
                resourceList.remove(resourceNum);
            }
        }

        */

    }

    @Override
    public void follow(GameObject leader) {
        ResourceObject currObject;
        for(int i = 0; i < resourceList.size(); i++)
        {
            if(resourceList.get(i) != null)
            {
                currObject = (ResourceObject)resourceList.get(i);
                currObject.moveTowards(leader);
            }
        }
    }
}
