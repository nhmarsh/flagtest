package com.nhmarsh.flagtest.repository;

import com.nhmarsh.flagtest.entity.FeatureFlag;
import org.springframework.data.repository.CrudRepository;

public interface FlagRepository extends CrudRepository<FeatureFlag, String> {
}
