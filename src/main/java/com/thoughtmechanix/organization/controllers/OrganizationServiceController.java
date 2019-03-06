package com.thoughtmechanix.organization.controllers;


import com.thoughtmechanix.organization.model.Organization;
import com.thoughtmechanix.organization.services.OrganizationService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@Api(value = "v1/organizations", tags = "组织服务接口模块")
@RestController
@RequestMapping(value = "v1/organizations")
public class OrganizationServiceController {
    @Autowired
    private OrganizationService orgService;
    private static final Logger logger = LoggerFactory.getLogger(OrganizationServiceController.class);

    @ApiOperation(value="通过组织ID获取组织信息", notes = "通过组织ID获取组织信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "organizationId", value = "组织ID", required = true, dataType = "String")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK",response = com.thoughtmechanix.organization.model.Organization.class)})
    @RequestMapping(value = "/{organizationId}", method = RequestMethod.GET)
    public Organization getOrganization(@PathVariable("organizationId") String organizationId) {
        logger.debug("Entering the getOrganization() method for the organizationId: {}", organizationId);
        Organization org = orgService.getOrg(organizationId);
        org.setContactName(org.getContactName());
        return org;
    }

    @RequestMapping(value = "/{organizationId}", method = RequestMethod.PUT)
    public void updateOrganization(@PathVariable("organizationId") String orgId, @RequestBody Organization org) {
        orgService.updateOrg(org);

    }

    @RequestMapping(value = "/{organizationId}", method = RequestMethod.POST)
    public void saveOrganization(@RequestBody Organization org) {
        orgService.saveOrg(org);
    }

    @RequestMapping(value = "/{organizationId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrganization(@PathVariable("organizationId") String orgId) {
        orgService.deleteOrg(orgId);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        logger.debug("Entering the getOrganization() method for the organizationId: {}");

        return "";
    }

    @ApiOperation(value="展示首页信息value", notes = "展示首页信息notes")
    @GetMapping("/show")
    public Object showInfo(){
        return "hello world";
    }

}
