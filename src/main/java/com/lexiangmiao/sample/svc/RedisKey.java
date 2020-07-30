package com.lexiangmiao.sample.svc;

/**
 * Created by mzxiao on 2020/7/29 9:54
 */
public final class RedisKey {
    final static String splitStr = ",";
    final static int oneYear = 365 * 24 * 60 * 60;

    private RedisKey() {
    }

    class School {
        final static int schoolQuatity = 2941;
        final static String schoolPage = "school_page_";
        final static String schoolIdpre = "school_";
        final static String allSchoolIds = "all_school_ids";
    }

    class ProvincialScore {
        final static String schoolPerYearScore = "school_per_year_score_%s/43/2/1.json";
    }

    public class SchoolSpecialty {
        final static String pre = "schoolspecialindex/%d/%s/43/%d/1.json";
    }

    public class SchoolPlan {
        final static String pre = "schoolplanindex/%d/%s/43/%d/%d/1.json";
    }
}
