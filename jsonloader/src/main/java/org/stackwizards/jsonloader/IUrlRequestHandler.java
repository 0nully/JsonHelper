package org.stackwizards.jsonloader;

import java.util.List;

public interface IUrlRequestHandler {
    public <T> List<T> onComplete(List<T> objs);

}
