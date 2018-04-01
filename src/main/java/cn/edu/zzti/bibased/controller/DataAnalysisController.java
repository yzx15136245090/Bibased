package cn.edu.zzti.bibased.controller;

import cn.edu.zzti.bibased.dto.Company;
import cn.edu.zzti.bibased.dto.PositionDetail;
import cn.edu.zzti.bibased.dto.Positions;
import cn.edu.zzti.bibased.service.operation.lagou.LagouOperationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据分析服务
 *
 * Created by huaidou on  2018/3/7
 */
@RestController
@RequestMapping("/rest")
public class DataAnalysisController {

    @Resource
    private LagouOperationService lagouOperationService;

    /**
     * 每个城市的公司数量
     * @return
     */
    @RequestMapping("/v1/queryCityCompanNum")
    @ResponseBody
    public List<Company> queryCityCompanNum(){
        return lagouOperationService.queryCityCompanNum();
    }

    /**
     * 全国公司融资情况图 和 职位类型数据
     * @return
     */
    @RequestMapping("/v1/queryFinanceStageCompanNum")
    @ResponseBody
    public  List<Company> queryFinanceStageCompanNum(){
        return lagouOperationService.queryFinanceStageCompanNum();
    }

    @RequestMapping("/v1/queryIndustryCompanNum")
    @ResponseBody
    public List<Company> queryIndustryCompanNum(){
        return lagouOperationService.queryIndustryCompanNum();
    }

    /**
     * 职位类型数据
     * @return
     */
    @RequestMapping("/v1/queryPositionTypeNums")
    @ResponseBody
    public List<Positions> queryPositionTypeNums(){
        return lagouOperationService.queryPositionTypeNums();
    }

    /**
     * 职位类型数据
     *
     * @return
     */
    @RequestMapping("/v1/queryWorkYearNums")
    @ResponseBody
    public List<PositionDetail> queryWorkYearNums(){
        return lagouOperationService.queryWorkYearNums();
    }

    /**
     * 职位类型数据
     *
     * @return
     */
    @RequestMapping("/v1/queryEducationNums")
    @ResponseBody
    public List<PositionDetail> queryEducationNums(){
        return lagouOperationService.queryEducationNums();
    }
    /**
     * 职位类型数据
     *
     * @return
     */
    @RequestMapping("/v1/queryJobNatureNums")
    @ResponseBody
    public List<PositionDetail> queryJobNatureNums(){
        return lagouOperationService.queryJobNatureNums();
    }
    /**
     * 拉钩技术类型下 各种职位类型的职位数量
     *
     * @return
     */
    @RequestMapping("/v1/queryPositionDetailsByJS")
    @ResponseBody
    public List<PositionDetail> queryPositionDetailsByFirstTye(){
        return lagouOperationService.queryPositionDetailsByFirstTye("技术");
    }
    /**
     * 拉钩  不同公司规模的职位数量
     *
     * @return
     */
    @RequestMapping("/v1/queryCompanySize")
    @ResponseBody
    public List<PositionDetail> queryCompanySize(){
        return lagouOperationService.queryCompanySize();
    }
    /**
     * 获取每个招聘网站在各个城市的职位数量
     *
     * @return
     */
    @RequestMapping("/v1/queryWebCityNums")
    @ResponseBody
    public Map<String,List<PositionDetail>> queryWebCityNums(){
        return lagouOperationService.queryWebCityNums();
    }
}