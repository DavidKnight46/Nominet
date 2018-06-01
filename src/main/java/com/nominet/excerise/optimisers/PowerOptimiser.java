package com.nominet.excerise.optimisers;

import com.nominet.excerise.model.Result;
import com.nominet.excerise.model.Scenario;

public interface PowerOptimiser {
    Result optimise(Scenario scenario);
}
