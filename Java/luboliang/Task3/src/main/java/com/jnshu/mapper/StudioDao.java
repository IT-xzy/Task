package com.jnshu.mapper;

import com.jnshu.model.Studio;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface StudioDao {

    public long addStudio(Studio studio);

    public boolean deleteStudio(long id);

    public boolean updateStudio(Studio studio);

    public Studio findByStudio(long id);

    public List<Studio> findAllStudio();


}
