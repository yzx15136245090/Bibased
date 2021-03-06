package cn.edu.zzti.bibased.dao.lagou;

import cn.edu.zzti.bibased.constant.WebsiteEnum;
import cn.edu.zzti.bibased.dao.cache.Cache;
import cn.edu.zzti.bibased.dao.mapper.CompanyMapper;
import cn.edu.zzti.bibased.dao.mapper.PositionDetailMapper;
import cn.edu.zzti.bibased.dao.mapper.PositionsMapper;
import cn.edu.zzti.bibased.dto.*;
import cn.edu.zzti.bibased.dto.query.PositionDetailQuery;
import cn.edu.zzti.bibased.utils.DateUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 用于数据的查询
 */
@Repository
public class LagouDao  {

    @Resource
    private Cache cache;
    @Resource
    private PositionsMapper positionsMapper;

    @Resource
    private CompanyMapper companyMapper;

    @Resource
    private PositionDetailMapper positionDetailMapper;

    @Resource
    private ActionLogDao actionLogDao;

    public Long queryLastPositionCreateTime(String city,String thirdType){
        Long positionDetail = positionDetailMapper.selectLastPostionCreateTime(WebsiteEnum.LAGOU.getWebCode(),city,thirdType);
        return positionDetail !=null?positionDetail:0L;
    }
    public List<ActionLogDO> queryActionLog(int typeCode){
        return actionLogDao.queryActionLog(WebsiteEnum.LAGOU.getWebCode(),typeCode);
    }
    /**
     *总的公司数量
     */
    public int queryCompanyDetailsByCount(){
        return companyMapper.queryCompanyDetailsByCount();
    }
    /**
     * 1.分析各个城市的公司数量 去重
     */
    public List<Company> queryCityCompanNum(){
        if(cache.containsKey(prefix()+"queryCityCompanNum")){
            return (List<Company>)cache.getValue(prefix()+"queryCityCompanNum");
        }else{
            List<Company> companies = companyMapper.queryCityCompanNum(WebsiteEnum.LAGOU.getWebCode());
            cache.add(prefix()+"queryCityCompanNum",companies);
            return companies;
        }
    }
    /**
     * 1.各个城市融资情况公司数量
     */
    public List<Company> queryFinanceStageCompanNum(){
        if(cache.containsKey(prefix()+"queryFinanceStageCompanNum")){
            return (List<Company>)cache.getValue(prefix()+"queryFinanceStageCompanNum");
        }else{
            List<Company> companies = companyMapper.queryFinanceStageCompanNum(WebsiteEnum.LAGOU.getWebCode());
            cache.add(prefix()+"queryFinanceStageCompanNum",companies);
            return companies;
        }
    }
    /**
     * 1.分析各个城市行业领域公司数量 去重
     */
    public List<Company> queryIndustryCompanNum(){
        if(cache.containsKey(prefix()+"queryIndustryCompanNum")){
            return (List<Company>)cache.getValue(prefix()+"queryIndustryCompanNum");
        }else{
            List<Company> companies = companyMapper.queryIndustryCompanNum(WebsiteEnum.LAGOU.getWebCode());
            cache.add(prefix()+"queryIndustryCompanNum",companies);
            return companies;
        }
    }
    /**
     * 查询职位类型数据统计
     *
     * @return
     */
    public List<Positions> queryPositionTypeNums(){
        return positionsMapper.queryPositionTypeNums(WebsiteEnum.LAGOU.getWebCode());
    }

    public List<PositionDetail> queryWorkYearNums(){
        if(cache.containsKey(prefix()+"queryWorkYearNums")){
            return (List<PositionDetail>)cache.getValue(prefix()+"queryWorkYearNums");
        }else{
            List<PositionDetail> positionDetails = positionDetailMapper.queryWorkYearNums(WebsiteEnum.LAGOU.getWebCode());
            cache.add(prefix()+"queryWorkYearNums",positionDetails);
            return positionDetails;
        }
    }

    public List<PositionDetail> queryEducationNums(){
        if(cache.containsKey(prefix()+"queryEducationNums")){
            return (List<PositionDetail>)cache.getValue(prefix()+"queryEducationNums");
        }else{
            List<PositionDetail> positionDetails =  positionDetailMapper.queryEducationNums(WebsiteEnum.LAGOU.getWebCode());
            cache.add(prefix()+"queryEducationNums",positionDetails);
            return positionDetails;
        }
    }

    public List<PositionDetail> queryJobNatureNums(){
        if(cache.containsKey(prefix()+"queryJobNatureNums")){
            return (List<PositionDetail>)cache.getValue(prefix()+"queryJobNatureNums");
        }else{
            List<PositionDetail> positionDetails = positionDetailMapper.queryJobNatureNums(WebsiteEnum.LAGOU.getWebCode());
            cache.add(prefix()+"queryJobNatureNums",positionDetails);
            return positionDetails;
        }
    }
    public List<PositionDetail> queryPositionDetailsByFirstTye(String firstType){
        if(cache.containsKey(prefix()+"queryPositionDetailsByFirstTye")){
            return (List<PositionDetail>)cache.getValue(prefix()+"queryPositionDetailsByFirstTye");
        }else{
            List<PositionDetail> positionDetails = positionDetailMapper.queryPositionDetailsByFirstTye(WebsiteEnum.LAGOU.getWebCode(),firstType);
            cache.add(prefix()+"queryPositionDetailsByFirstTye",positionDetails);
            return positionDetails;
        }
    }

    public List<PositionDetail> queryCompanySize(){
        if(cache.containsKey(prefix()+"queryCompanySize")){
            return (List<PositionDetail>)cache.getValue(prefix()+"queryCompanySize");
        }else{
            List<PositionDetail> positionDetails = positionDetailMapper.queryCompanySize(WebsiteEnum.LAGOU.getWebCode());
            cache.add(prefix()+"queryCompanySize",positionDetails);
            return positionDetails;
        }
    }
    /**
     * 获取每个招聘网站在各个城市的职位数量
     * @return
     */
    public List<PositionDetail> queryWebCityNums(){
        if(cache.containsKey(prefix()+"queryWebCityNums")){
            return (List<PositionDetail>)cache.getValue(prefix()+"queryWebCityNums");
        }else{
            List<PositionDetail> positionDetails = positionDetailMapper.queryWebCityNums();
            cache.add(prefix()+"queryWebCityNums",positionDetails);
            return positionDetails;
        }
    }

    private String prefix(){
        return DateUtils.formatStr(new Date(),DateUtils.YYMMDD)+WebsiteEnum.LAGOU.getWebCode();
    }
    private String prefix(String include){
        return DateUtils.formatStr(new Date(),DateUtils.YYMMDD)+include;
    }
    /**
     * 通用查询
     *
     * @param query
     * @return
     */
    public List<PositionDetail> queryPositionDetailWithBaseQuery(PositionDetailQuery query){
        return positionDetailMapper.queryPositionDetailWithBaseQuery(query);
    }
    public List<PositionDetail> queryDifferentSalaryNum(String include){
        if(cache.containsKey(prefix(include)+"queryDifferentSalaryNum")){
            return (List<PositionDetail>)cache.getValue(prefix(include)+"queryDifferentSalaryNum");
        }else{
            List<PositionDetail> positionDetails = positionDetailMapper.queryDifferentSalaryNum(include);
            cache.add(prefix(include)+"queryDifferentSalaryNum",positionDetails);
            return positionDetails;
        }

    }

    public List<Integer> queryPositionIdsByTodayWithThirdType(String thirdTpe){
        return positionDetailMapper.queryPositionIdsByTodayWithThirdType(thirdTpe);
    }
}
