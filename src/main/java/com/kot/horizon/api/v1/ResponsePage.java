package com.kot.horizon.api.v1;

import java.util.List;

public class ResponsePage< T > {
    private List< T > items;
    private long count;

    public ResponsePage(List< T > items, long count) {
        this.items = items;
        this.count = count;
    }

    public List< T > getItems() {
        return items;
    }

    public long getCount() {
        return count;
    }
}