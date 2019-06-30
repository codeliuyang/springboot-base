package ${packageName}.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ${packageName}.core.AuditCore;
import ${packageName}.dto.${domainNameUpper}DTO;
import ${packageName}.mapper.gen.${domainNameUpper}Mapper;
import ${packageName}.model.gen.${domainNameUpper};
import ${packageName}.model.gen.${domainNameUpper}Criteria;
import ${packageName}.service.${domainNameUpper}Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * -
 *
 * @auther: yangliu
 * create date: 08-06-2019
 */
@Service
public class ${domainNameUpper}ServiceImpl implements ${domainNameUpper}Service {

    @Autowired
    private ${domainNameUpper}Mapper ${domainNameLower}Mapper;

    @Override
    public ${domainNameUpper} getById(Long ${domainNameLower}Id) {
        return ${domainNameLower}Mapper.selectByPrimaryKey(${domainNameLower}Id);
    }

    @Override
    public ${domainNameUpper} getByQuery(${domainNameUpper}DTO ${domainNameLower}DTO) {
        ${domainNameUpper}Criteria ${domainNameLower}Criteria = new ${domainNameUpper}Criteria();
        ${domainNameUpper}Criteria.Criteria criteria = ${domainNameLower}Criteria.createCriteria();
        criteria.andDelFlagEqualTo(0);
        List<${domainNameUpper}> ${domainNameLower}s = this.get${domainNameUpper}s(${domainNameLower}DTO);
        if(CollectionUtils.isEmpty(${domainNameLower}s)){
            return null;
        } else {
            return ${domainNameLower}s.get(0);
        }
    }

    @Override
    public List<${domainNameUpper}> get${domainNameUpper}s(${domainNameUpper}DTO query) {
        ${domainNameUpper}Criteria ${domainNameLower}Criteria = new ${domainNameUpper}Criteria();
        ${domainNameUpper}Criteria.Criteria criteria = ${domainNameLower}Criteria.createCriteria();
        criteria.andDelFlagEqualTo(0);
        ${domainNameLower}Criteria.setOrderByClause("create_time desc");
        List<${domainNameUpper}> ${domainNameLower}s = ${domainNameLower}Mapper.selectByExample(${domainNameLower}Criteria);
        return ${domainNameLower}s;
    }

    @Override
    public PageInfo<${domainNameUpper}> get${domainNameUpper}Page(${domainNameUpper}DTO query, int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<${domainNameUpper}> ${domainNameLower}s = this.get${domainNameUpper}s(query);
        return new PageInfo<>(${domainNameLower}s);
    }

    @Override
    public Long create${domainNameUpper}(${domainNameUpper}DTO ${domainNameLower}DTO) {
        ${domainNameUpper} ${domainNameLower} = new ${domainNameUpper}();
        BeanUtils.copyProperties(${domainNameLower}DTO, ${domainNameLower});
        AuditCore.setAuditPropsForCreated(${domainNameLower});
        ${domainNameLower}Mapper.insert(${domainNameLower});
        return ${domainNameLower}.get${domainNameUpper}Id();
    }

    @Override
    public Long update${domainNameUpper}(${domainNameUpper}DTO ${domainNameLower}DTO, Long ${domainNameLower}Id) {
        ${domainNameUpper} ${domainNameLower} = new ${domainNameUpper}();
        BeanUtils.copyProperties(${domainNameLower}DTO, ${domainNameLower});
        ${domainNameLower}.set${domainNameUpper}Id(${domainNameLower}Id);
        AuditCore.setAuditPropsForUpdated(${domainNameLower});
        ${domainNameLower}Mapper.updateByPrimaryKeySelective(${domainNameLower});
        return ${domainNameLower}.get${domainNameUpper}Id();
    }

    @Override
    public void remove${domainNameUpper}(Long ${domainNameLower}Id) {
        ${domainNameUpper} ${domainNameLower} = ${domainNameLower}Mapper.selectByPrimaryKey(${domainNameLower}Id);
        ${domainNameLower}.setDelFlag(1);
        AuditCore.setAuditPropsForUpdated(${domainNameLower});
        ${domainNameLower}Mapper.updateByPrimaryKeySelective(${domainNameLower});
    }
}
