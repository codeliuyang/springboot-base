package ${packageName}.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import ${packageName}.dto.${domainNameUpper}DTO;
import ${packageName}.model.gen.${domainNameUpper};

import java.util.List;

/**
 * -
 *
 * @auther: yangliu
 * create date: 08-06-2019
 */
public interface ${domainNameUpper}Service {

    ${domainNameUpper} getById(Long ${domainNameLower}DTO);

    ${domainNameUpper} getByQuery(${domainNameUpper}DTO query);

    List<${domainNameUpper}> get${domainNameUpper}s(${domainNameUpper}DTO query);

    PageInfo<${domainNameUpper}> get${domainNameUpper}Page(${domainNameUpper}DTO query, int pageNumber, int pageSize);

    Long create${domainNameUpper}(${domainNameUpper}DTO ${domainNameLower}DTO);

    Long update${domainNameUpper}(${domainNameUpper}DTO ${domainNameLower}DTO, Long ${domainNameLower}Id);

    void remove${domainNameUpper}(Long ${domainNameLower}Id);

}
