package com.genise.zytec.baserecyclerviewadapterhelperdemo.data;

import com.chad.library.adapter.base.entity.SectionMultiEntity;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.MultipleItem;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.MySection;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.NormalMultipleEntity;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.SectionMultipleItem;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.Status;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.Video;

import java.util.ArrayList;
import java.util.List;

public class DataServer {
    private static final String HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK = "https://avatars1.githubusercontent.com/u/7698209?v=3&s=460";

    private static final String CYM_CHAD = "CymChad";
    private static final String CHAY_CHAN = "ChayChan";

    private DataServer() {
    }

    public static List<Status> getSimpleData(int length) {
        List<Status> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            Status status = new Status();
            status.setUserName("Chad" + i);
            status.setCreatedAt("04/05/" + i);
            status.setRetweet(i % 2 == 0);
            status.setUserAvatar("https://avatars1.githubusercontent.com/u/7698209?v=3&s=460");
            status.setText("BaseRecyclerViewAdpaterHelper https://www.recyclerview.org");
            list.add(status);
        }
        return list;
    }

    public static List<MySection> getSampleData() {
        List<MySection> list = new ArrayList<>();
        list.add(new MySection(true, "Section 1", true));
        list.add(new MySection(new Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)));
        list.add(new MySection(new Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)));
        list.add(new MySection(new Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)));
        list.add(new MySection(new Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)));
        list.add(new MySection(true, "Section 2", false));
        list.add(new MySection(new Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)));
        list.add(new MySection(new Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)));
        list.add(new MySection(new Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)));
        list.add(new MySection(true, "Section 3", false));
        list.add(new MySection(new Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)));
        list.add(new MySection(new Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)));
        list.add(new MySection(true, "Section 4", false));
        list.add(new MySection(new Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)));
        list.add(new MySection(new Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)));
        list.add(new MySection(true, "Section 5", false));
        list.add(new MySection(new Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)));
        list.add(new MySection(new Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD)));
        return list;
    }

    public static List<MultipleItem> getMultipleItemData() {
        List<MultipleItem> list = new ArrayList<>();
        for (int i = 0; i <= 4; i++) {
            list.add(new MultipleItem(MultipleItem.IMG, MultipleItem.IMG_SPAN_SIZE));
            list.add(new MultipleItem(MultipleItem.TEXT, MultipleItem.TEXT_SPAN_SIZE, CYM_CHAD));
            list.add(new MultipleItem(MultipleItem.IMG_TEXT, MultipleItem.IMG_TEXT_SPAN_SIZE));
            list.add(new MultipleItem(MultipleItem.IMG_TEXT, MultipleItem.IMG_TEXT_SPAN_SIZE_MIN));
            list.add(new MultipleItem(MultipleItem.IMG_TEXT, MultipleItem.IMG_TEXT_SPAN_SIZE_MIN));
        }
        return list;
    }

    public static List<NormalMultipleEntity> getNormalMultipleEntities() {
        List<NormalMultipleEntity> list = new ArrayList<>();
        for (int i = 0; i <= 4; i++) {
            list.add(new NormalMultipleEntity(NormalMultipleEntity.SINGLE_IMG));
            list.add(new NormalMultipleEntity(NormalMultipleEntity.SINGLE_TEXT,CHAY_CHAN));
            list.add(new NormalMultipleEntity(NormalMultipleEntity.TEXT_IMG,CHAY_CHAN));
            list.add(new NormalMultipleEntity(NormalMultipleEntity.TEXT_IMG,CYM_CHAD));
            list.add(new NormalMultipleEntity(NormalMultipleEntity.TEXT_IMG,CHAY_CHAN));
        }
        return list;
    }

    public static List<SectionMultiEntity> getSectionMultiData() {
        List<SectionMultiEntity> list = new ArrayList<>();
        Video video = new Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, CYM_CHAD);

        //add section data
        list.add(new SectionMultipleItem(true, "Section 1", true));
        //add multiple type item data ---start---
        list.add(new SectionMultipleItem(SectionMultipleItem.TEXT, new Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, "video_id_0")));
        list.add(new SectionMultipleItem(SectionMultipleItem.TEXT, new Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, "video_id_1")));
        list.add(new SectionMultipleItem(SectionMultipleItem.TEXT, new Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, "video_id_2")));
        //---end---
        list.add(new SectionMultipleItem(true, "Section 2", false));
        list.add(new SectionMultipleItem(SectionMultipleItem.IMG_TEXT, video));
        list.add(new SectionMultipleItem(SectionMultipleItem.IMG_TEXT, video));
        list.add(new SectionMultipleItem(SectionMultipleItem.TEXT, video));
        list.add(new SectionMultipleItem(SectionMultipleItem.TEXT, video));
        list.add(new SectionMultipleItem(true, "Section 3", false));
        list.add(new SectionMultipleItem(SectionMultipleItem.IMG_TEXT, video));
        list.add(new SectionMultipleItem(true, "Section 4", false));
        list.add(new SectionMultipleItem(SectionMultipleItem.TEXT, video));
        list.add(new SectionMultipleItem(true, "Section 5", false));
        list.add(new SectionMultipleItem(SectionMultipleItem.IMG_TEXT, video));
        list.add(new SectionMultipleItem(SectionMultipleItem.IMG_TEXT, video));
        list.add(new SectionMultipleItem(SectionMultipleItem.IMG_TEXT, video));

        return list;
    }
}
