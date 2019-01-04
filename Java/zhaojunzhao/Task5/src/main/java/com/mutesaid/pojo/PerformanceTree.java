package com.mutesaid.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Joe
 */
public class PerformanceTree {

    private ArrayList<Element> elements;

    public PerformanceTree(ArrayList<Element> elements) {
        this.elements = elements;
        // 添加子节点
        for (Element item : elements) {
            if (item != null) {
                item.setChrildren(getChildren(item));
            }
        }
    }

    /* 根据结构化绩效表存储指标及父子关系 */
    public void getElements(ArrayList<Element> template, Long parentId, ArrayList<Element> elements) {
        for (Element aTemplate : template) {
            // 没有节点新增数据
            if (aTemplate.getId() == null) {
                // 设置父节点Id
                aTemplate.setParentId(parentId);
                // 添加到数据库，添加id
                // *********
                Long id = 0L;
                // 添加到数组
                elements.add(aTemplate);
                // 获取节点的子节点
                ArrayList<Element> chrildren = aTemplate.getChrildren();
                for (Element aChrildren : chrildren) {
                    getElements(aChrildren.getChrildren(), id, elements);
                }
                // 有节点进行更新
            } else {
                // 更新数据
                // ********
                Long id = 0L;
                elements.add(aTemplate);
                // 获取节点的子节点
                ArrayList<Element> chrildren = aTemplate.getChrildren();
                for (Element aChrildren : chrildren) {
                    getElements(aChrildren.getChrildren(), id, elements);
                }
            }
        }
    }

    /* 添加子节点 */
    public void addElement(Element element) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) == null) {
                elements.set(i, element);
                break;
            } else {
                elements.add(element);
                break;
            }
        }
    }

    /* 获取指定节点的子节点 */
    public ArrayList<Element> getChildren(Element element) {
        ArrayList<Element> childrenList = new ArrayList<>();
        for (Element element1 : elements) {
            if (element1 != null && element1.getParentId().equals(element.getId())) {
                childrenList.add(element1);
            }
        }
        return childrenList;
    }

    /* 获取根节点 */
    public Element getRoot() {
        Element root = null;
        for (Element element : elements) {
            if (element != null && element.getParentId() == -1) {
                root = element;
            }
        }
        return root;
    }

    /* 获取指定节点下的全部叶子节点 */
    public static void getTreeList(Element element, ArrayList treeList) {
        List<Element> chrildren = element.getChrildren();
        for (int i = 0; i < chrildren.size(); i++) {
            if (chrildren.get(i).getChrildren().size() == 0) {
                treeList.add(chrildren.get(i));
            } else {
                getTreeList(chrildren.get(i), treeList);
            }
        }
    }

    /* 删除指定节点下所有的子树 */
    public void removeChildren(Element element) {
        for (int i = 0; i < elements.size(); i++) {
            // 删除根节点下的子节点
            if (elements.get(i) != null && elements.get(i).getParentId().equals(element.getId())) {
                // 递归删除该子节下的子节点
                removeChildren(elements.get(i));
                elements.set(i, null);
            }
            // 删除根节点，删到最后还剩下一个最开始的根节点没有删除，没有更好的地方放这个判断了
            if (elements.get(i) != null && elements.get(i).getId().equals(element.getId())) {
                elements.set(i, null);
            }
        }
    }

    /* 返回整个树的map */
    public Element outPerformanceMap() {
        return getRoot();
    }
}
