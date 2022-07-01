package org.robolectric.shadows;

import static android.os.Build.VERSION_CODES.LOLLIPOP;
import static android.os.Build.VERSION_CODES.LOLLIPOP_MR1;
import static android.os.Build.VERSION_CODES.M;
import static android.os.Build.VERSION_CODES.O_MR1;
import static android.os.Build.VERSION_CODES.P;

import android.text.StaticLayout;

import org.robolectric.annotation.ClassName;
import org.robolectric.annotation.HiddenApi;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

@Implements(value = StaticLayout.class, looseSignatures = true)
public class ShadowStaticLayout {

  @Implementation(minSdk = LOLLIPOP, maxSdk = LOLLIPOP_MR1)
  @HiddenApi
  public static int[] nLineBreakOpportunities(String locale, char[] text, int length, int[] recycle) {
    return new int[] {-1};
  }

  @HiddenApi
  @Implementation(minSdk = M, maxSdk = O_MR1)
  public static int nComputeLineBreaks(Object nativePtr, Object recycle,
            Object recycleBreaks, Object recycleWidths, Object recycleFlags, Object recycleLength) {
    return 1;
  }

  @Implementation(minSdk = P, maxSdk = P)
  @HiddenApi
  protected static int nComputeLineBreaks(
          long nativePtr,
          char[] text,
          long measuredTextPtr,
          int length,
          float firstWidth,
          int firstWidthLineCount,
          float restWidth,
          int[] variableTabStops,
          int defaultTabStop,
          int indentsOffset,
          @ClassName("android.text.StaticLayout$LineBreaks") Object recycle,
          int recycleLength,
          int[] recycleBreaks,
          float[] recycleWidths,
          float[] recycleAscents,
          float[] recycleDescents,
          int[] recycleFlags,
          float[] charWidths) {
    return 1;
  }
}
