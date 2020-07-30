-- 湖南一本每年最低录取分
SELECT
  p2.year,
  p2.min,
  s.name,
  p2.school_id
FROM (
       SELECT
         p.year,
         min(p.min) AS min
       FROM
         provincial_score p
       WHERE
         p.min > 0
         AND p.batch = 7
       GROUP BY p.year
     ) m
  JOIN (
         SELECT *
         FROM
           provincial_score
         WHERE
           min > 0
           AND batch = 7
       ) p2 ON p2.year = m.year AND p2.min = m.min
JOIN school_info s ON p2.school_id=s.school_id
ORDER BY p2.year;


-- 湖南每年一本压线录取10大学校
SELECT  x.year,
  x.min,
  s.name,
  s.province_name,
  x.local_batch_name,
  x.zslx_name,
  concat('https://gkcx.eol.cn/school/',x.school_id,+'/provinceline') as url
  FROM school_info s
JOIN (
      (SELECT *
       FROM provincial_score
       WHERE min > 0 AND batch = 7 AND year = 2019
       ORDER BY min
       LIMIT 10)
      UNION ALL
      (SELECT *
       FROM provincial_score
       WHERE min > 0 AND batch = 7 AND year = 2018
       ORDER BY min
       LIMIT 10)
      UNION ALL
      (SELECT *
       FROM provincial_score
       WHERE min > 0 AND batch = 7 AND year = 2017
       ORDER BY min
       LIMIT 10)
      UNION ALL
      (SELECT *
       FROM provincial_score
       WHERE min > 0 AND batch = 7 AND year = 2016
       ORDER BY min
       LIMIT 10)
      UNION ALL
      (SELECT *
       FROM provincial_score
       WHERE min > 0 AND batch = 7 AND year = 2015
       ORDER BY min
       LIMIT 10)
      ) x ON x.school_id=s.school_id
ORDER BY x.year DESC,x.min ASC

-- 湖南每年二本高分录取10大学校
SELECT  x.year,
  x.min,
  s.name,
  s.province_name,
  x.local_batch_name,
  x.zslx_name,
  concat('https://gkcx.eol.cn/school/',x.school_id,+'/provinceline') as url
  FROM school_info s
JOIN (
      (SELECT *
       FROM provincial_score
       WHERE min > 0 AND batch = 8 AND year = 2019
       ORDER BY min desc
       LIMIT 10)
      UNION ALL
      (SELECT *
       FROM provincial_score
       WHERE min > 0 AND batch = 8 AND year = 2018
       ORDER BY min desc
       LIMIT 10)
      UNION ALL
      (SELECT *
       FROM provincial_score
       WHERE min > 0 AND batch = 8 AND year = 2017
       ORDER BY min desc
       LIMIT 10)
      UNION ALL
      (SELECT *
       FROM provincial_score
       WHERE min > 0 AND batch = 8 AND year = 2016
       ORDER BY min desc
       LIMIT 10)
      UNION ALL
      (SELECT *
       FROM provincial_score
       WHERE min > 0 AND batch = 8 AND year = 2015
       ORDER BY min desc
       LIMIT 10)
      ) x ON x.school_id=s.school_id
ORDER BY x.year DESC,x.min DESC


-- 每所学校在湖南的最低录取分
SELECT  x.year,
  x.min,
  s.name,
  s.province_name,
  x.local_batch_name,
  x.zslx_name,
  concat('https://gkcx.eol.cn/school/',x.school_id,+'/provinceline') as url
  FROM school_info s
JOIN (
      (SELECT min(`min`) as min
       FROM provincial_score
       WHERE min > 0 AND batch = 7 AND year = 2019 and school_id=s.school_id)
      ) x ON x.school_id=s.school_id
ORDER BY x.year DESC,x.min DESC

-- 查具体某一所学校的每年的最低录取分数
SELECT
  s.name,
  s.province_name,
  x.batch,
  x.local_batch_name,
  x.year,
  x.min,
  concat('https://gkcx.eol.cn/school/', x.school_id, +'/provinceline') AS url
FROM school_info s
  JOIN (
         SELECT
           school_id,
           year,
           batch,
           local_batch_name,
           min(min) AS min
         FROM provincial_score
         WHERE min > 0
         GROUP BY school_id, year, batch, local_batch_name
       ) x ON x.school_id = s.school_id
WHERE 1=1
AND s.school_id in (544)
ORDER BY x.batch,x.year,x.min

-- 每年一本录取最低位次的10所学校
SELECT  x.year,
  x.min_section,
  x.min,
  s.name,
  s.province_name,
  x.local_batch_name,
  x.zslx_name,
  concat('https://gkcx.eol.cn/school/',x.school_id,+'/provinceline') as url
FROM school_info s
  JOIN (
         (SELECT *
          FROM provincial_score
          WHERE min_section > 0 AND batch = 7 AND year = 2019
          ORDER BY min_section desc
          LIMIT 10)
         UNION ALL
         (SELECT *
          FROM provincial_score
          WHERE min_section > 0 AND batch = 7 AND year = 2018
          ORDER BY min_section desc
          LIMIT 10)
         UNION ALL
         (SELECT *
          FROM provincial_score
          WHERE min_section > 0 AND batch = 7 AND year = 2017
          ORDER BY min_section desc
          LIMIT 10)
         UNION ALL
         (SELECT *
          FROM provincial_score
          WHERE min_section > 0 AND batch = 7 AND year = 2016
          ORDER BY min_section desc
          LIMIT 10)
         UNION ALL
         (SELECT *
          FROM provincial_score
          WHERE min_section > 0 AND batch = 7 AND year = 2015
          ORDER BY min_section desc
          LIMIT 10)
       ) x ON x.school_id=s.school_id
ORDER BY x.year DESC,x.min_section DESC

-- 指定一本的专业录取位次和分数
SELECT  x.year,
  x.min_section,
  x.min,
  s.name,
  s.province_name,
  x.spname,
  x.*,
  concat('https://gkcx.eol.cn/school/',x.school_id,+'/provinceline') as url
FROM school_info s
  JOIN (
         (SELECT *
          FROM school_specialty
           WHERE batch =7
          AND school_id in(402,406)
#            AND level2=7
#            AND level3 in (47,48)
         )
       ) x ON x.school_id=s.school_id
ORDER BY x.year DESC,x.min_section DESC



-- 预测录取学校
SELECT
  x.year,
  x.min_section,
  x.min,
  s.name,
  s.province_name,
  x.local_batch_name,
  x.zslx_name,
  concat('https://gkcx.eol.cn/school/', x.school_id, +'/provinceline') AS url
FROM school_info s
  JOIN (
         -- 年份      参考人数    文科  反推位数
         -- 2017      410800      152900  12770
         -- 2018      451800      168700  13175
         -- 2019      499000      185000  14448
         -- 2020      536000      194000  15151
         (SELECT *
          FROM provincial_score
          WHERE batch = 7
                AND year = 2019
                AND min_section > 14448
         )
         UNION ALL
         (SELECT *
          FROM provincial_score
          WHERE batch = 7
                AND year = 2018
                AND min_section > 13175
         )
         UNION ALL
         (SELECT *
          FROM provincial_score
          WHERE batch = 7
                AND year = 2017
                AND min_section > 12770
         )
       ) x ON x.school_id = s.school_id
ORDER BY x.year DESC, x.min_section DESC


