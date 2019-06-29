package ${packageName}.api;

import com.github.pagehelper.PageInfo;
import com.lerr.demo.core.HttpResult;
import ${packageName}.dto.${domainNameUpper}DTO;
import ${packageName}.model.gen.${domainNameUpper};
import ${packageName}.service.${domainNameUpper}Service;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * -
 *
 * @auther: yangliu
 * create date: 08-06-2019
 */
@RestController
@RequestMapping("/${domainNameAllLower}s")
@Api(value="${comment}API", tags = "${comment}模块")
public class ${domainNameUpper}Api {

    @Autowired
    private ${domainNameUpper}Service ${domainNameLower}Service;

    @GetMapping("/{id}")
    public HttpResult<${domainNameUpper}> get${domainNameUpper}s(@PathVariable Long id){
        return HttpResult.success(${domainNameLower}Service.getById(id));
    }

    @GetMapping("/list")
    public HttpResult<List<${domainNameUpper}>> get${domainNameUpper}s(${domainNameUpper}DTO query){
        return HttpResult.success(${domainNameLower}Service.get${domainNameUpper}s(query));
    }

    @GetMapping("/page")
    public HttpResult<PageInfo<${domainNameUpper}>> get${domainNameUpper}Page(${domainNameUpper}DTO query,
                                      @RequestParam Integer pageNumber,
                                      @RequestParam Integer pageSize){
        return HttpResult.success(${domainNameLower}Service.get${domainNameUpper}Page(query, pageNumber, pageSize));
    }

    @PostMapping("")
    public HttpResult<Long> create${domainNameUpper}(@RequestBody ${domainNameUpper}DTO ${domainNameLower}DTO){
        return HttpResult.success(${domainNameLower}Service.create${domainNameUpper}(${domainNameLower}DTO));
    }

    @PutMapping("")
    public HttpResult<Long> update${domainNameUpper}(@RequestBody ${domainNameUpper}DTO ${domainNameLower}DTO){
        return HttpResult.success(${domainNameLower}Service.update${domainNameUpper}(${domainNameLower}DTO, ${domainNameLower}DTO.get${domainNameUpper}Id()));
    }

    @DeleteMapping("/{id}")
    public HttpResult remove${domainNameUpper}(@PathVariable Long id){
        ${domainNameLower}Service.remove${domainNameUpper}(id);
        return HttpResult.success(null, "success");
    }

}
