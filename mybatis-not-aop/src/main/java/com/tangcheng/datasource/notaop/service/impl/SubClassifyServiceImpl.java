package com.tangcheng.datasource.notaop.service.impl;

import com.tangcheng.datasource.notaop.mapper.ext.SubClassifyMapper;
import com.tangcheng.datasource.notaop.mapper.ext.SubRelationMapper;
import com.tangcheng.datasource.notaop.model.SubClassify;
import com.tangcheng.datasource.notaop.model.SubRelation;
import com.tangcheng.datasource.notaop.service.SubClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: Administrator
 * @Date: 2018/7/23 23:58
 * @Description:
 */
@Service
public class SubClassifyServiceImpl implements SubClassifyService {

    @Autowired
    private SubClassifyMapper subClassifyMapper;

    @Autowired
    private SubRelationMapper subRelationMapper;

    /**
     * subClassify-->usrOrg 、classifyNO、name
     *
     * @param subClassify
     */
    @Override
    public int addSubClassify(SubClassify subClassify) {
        boolean flag = false;
        if ("-1".equals(subClassify.getUsrOrg())) {
            flag = true;
        }
        if (flag) {
            subClassify.setId(System.currentTimeMillis() + "");
            subClassifyMapper.insertSelective(subClassify);
            // String id = System.currentTimeMillis()+"";
            SubRelation subRelation = new SubRelation();
            subRelation.setId(subClassify.getId());
            subRelation.setParentId("-1");
            // 自己同是自己的子节点
            subRelation.setRelative(subClassify.getId() + ",");
            subRelation.setSubId(subClassify.getId());
            subRelationMapper.insertSelective(subRelation);
            return 2;
        }

        // 获得父节点信息-------->包含父节点的就必定包含子节点
        SubClassify subClassify1 = subClassifyMapper.getClassifyByNo(subClassify.getUsrOrg());
        // 获得父节点的对应的关系
        SubRelation subRelation = subRelationMapper.selectByPrimaryKey(subClassify1.getId());
        //subRelation.setRelative(subRelation.getRelative() + subClassify.getId() + ",");

        // 获得包含父节点的上级节点
        List<SubRelation> list = subRelationMapper.likeRelativeByParentId(subClassify1.getId());
        List<SubRelation> collect = list.stream().map(p -> {
            p.setRelative(p.getRelative() + subClassify.getId() + ",");
            return p;
        }).collect(Collectors.toList());
        subRelationMapper.batchPrimaryKey(collect);
        // subRelationMapper.updateByPrimaryKeySelective(subRelation);
        subClassify.setId(System.currentTimeMillis()+"");
        subClassifyMapper.insertSelective(subClassify);

        return 3;

    }

    @PostConstruct
    public void TestDemo(){
        SubClassify subClassify = new SubClassify();
        subClassify.setUsrOrg("c-1");
        subClassify.setClassifyNo("c-2.1");
        subClassify.setName("cc-2.1");
        int i = addSubClassify(subClassify);
        System.out.println("---->"+i);

    }

}
