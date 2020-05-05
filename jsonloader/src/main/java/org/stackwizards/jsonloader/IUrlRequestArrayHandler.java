package org.stackwizards.jsonloader;

import java.util.List;

public interface IUrlRequestArrayHandler {
    <T> List<T> onComplete(List<T> objs);
}
