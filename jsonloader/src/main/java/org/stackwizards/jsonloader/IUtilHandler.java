package org.stackwizards.jsonloader;

import java.util.List;

public interface IUtilHandler {
    public <T> List<T> onReceive(List<T> objs);

}
