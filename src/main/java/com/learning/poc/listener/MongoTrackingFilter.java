package com.learning.poc.listener;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class MongoTrackingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, jakarta.servlet.ServletException {
        try {
           // MongoCommandListener.clear();
            chain.doFilter(request, response);

//            List<Map<String, Object>> impactedOperations = MongoCommandListener.getImpactedOperations();
//            ((HttpServletResponse) response).setHeader("Impacted-Collections", getCollectionsHeader(impactedOperations));
        } finally {
           // MongoCommandListener.clear();
        }
    }

    private String getCollectionsHeader(List<Map<String, Object>> impactedOperations) {
        Set<String> collections = new HashSet<>();
        for (Map<String, Object> op : impactedOperations) {
            collections.add((String) op.get("collection"));
        }
        return String.join(",", collections);
    }
}


