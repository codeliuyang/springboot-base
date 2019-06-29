package com.little.animal.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.little.animal.dto.${domainNameUpper}DTO;
import com.little.animal.model.gen.${domainNameUpper};

import java.util.List;

/**
 * -
 *
 * @auther: yangliu
 * create date: 08-06-2019
 */
public interface ${domainNameUpper}Service {

    ${domainNameUpper} getById(Long ${domainNameLower}DTO);

    ${domainNameUpper} getByQuery(${domainNameUpper}DTO ${domainNameLower}DTO);

    List<${domainNameUpper}> get${domainNameUpper}s(${domainNameUpper}DTO query);

    PageInfo<${domainNameUpper}> get${domainNameUpper}Page(${domainNameUpper}DTO query, int pageNumber, int pageSize);

    Long create${domainNameUpper}(${domainNameUpper}DTO ${domainNameLower}DTO);

    Long update${domainNameUpper}(${domainNameUpper}DTO ${domainNameLower}DTO, Long ${domainNameLower}Id);

    void remove${domainNameUpper}(Long ${domainNameLower}Id);

}
