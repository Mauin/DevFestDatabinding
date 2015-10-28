package com.mtramin.devfestdatabinding.util;

import com.mtramin.devfestdatabinding.data.AndroidVersion;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: JAVADOC
 */
public class AndroidVersionUtil {

    public static List<AndroidVersion> createVersionList() {
        List<AndroidVersion> versions = new ArrayList<>();
        versions.add(new AndroidVersion("Cupcake", "1.5", 3, "April 2009", "http://www6.pcmag.com/media/images/318812-android-cupcake.jpg?thumb=y"));
        versions.add(new AndroidVersion("Donut", "1.6", 4, "September 2009", "http://www.stealthcopter.com/blog/wp-content/uploads/2010/05/2010-05-19-17.57.22-600x800.jpg"));
        versions.add(new AndroidVersion("Eclair", "2.0", 5, "October 2009", "https://d38ls2kcjnhfdj.cloudfront.net/b0eee805-a989-4072-aaea-e299459153ca.jpg"));
        versions.add(new AndroidVersion("Froyo", "2.2", 8, "May 2010", "http://picomol.de/wp-content/uploads/android_froyo.jpg"));
        versions.add(new AndroidVersion("Gingerbread", "2.3", 9, "December 2010", "http://img.talkandroid.com/uploads/2011/11/Android-Gingerbread-Statue.jpg"));
        versions.add(new AndroidVersion("Honeycomb", "3.0", 11, "February 2011", "http://sculptsite.com/Archive/images/honeycomb5.jpg"));
        versions.add(new AndroidVersion("Ice Cream Sandwich", "4.0", 14, "October 2011", "https://courses.cs.washington.edu/courses/cse455/12wi/projects/project1/web/voting/artifacts/webpages/laurejt/ice_cream_sandwich.jpg"));
        versions.add(new AndroidVersion("Jelly Bean", "4.1", 16, "July 2012", "http://www.droid-guru.com/wp-content/uploads/2012/06/IMG_20120626_124059.jpg"));
        versions.add(new AndroidVersion("Kit Kat", "4.4", 19, "October 2013", "http://www.androidcentral.com/sites/androidcentral.com/files/styles/large/public/article_images/2014/02/kitkat-statue-1.jpg?itok=UmLMcPN4"));
        versions.add(new AndroidVersion("Lollipop", "5.0", 21, "November 2014", "http://www.androidcentral.com/sites/androidcentral.com/files/styles/large_wm_brw/public/article_images/2014/10/lollipop-statue-1.jpg?itok=Ikh29MXd"));
        versions.add(new AndroidVersion("Marshmallow", "6.0", 23, "October 2015", "http://aptgadget.com/wp-content/uploads/2015/08/4cadabde3185a562711e456405d4e69f77265174.jpeg"));
        versions.add(new AndroidVersion("Nougat", null, 0, null, null));
        return versions;
    }

    public static boolean isCurrent(int apiLevel) {
        return apiLevel == 23;
    }
}
