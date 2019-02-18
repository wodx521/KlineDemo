package com.github.mikephil.charting.stockChart.data;

import com.github.mikephil.charting.stockChart.model.ADX;
import com.github.mikephil.charting.stockChart.model.ATR;
import com.github.mikephil.charting.stockChart.model.HqDefaultValue;
import com.github.mikephil.charting.stockChart.model.KDJ;
import com.github.mikephil.charting.stockChart.model.KLineDataModel;
import com.github.mikephil.charting.stockChart.model.MACD;
import com.github.mikephil.charting.stockChart.model.RSI;
import com.tictactec.ta.lib.Core;
import com.tictactec.ta.lib.MAType;
import com.tictactec.ta.lib.MInteger;
import com.tictactec.ta.lib.RetCode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HqUtils {
    public static int leftFormat = 0;
    public static int rightFormat = 2;

    public static List<ADX> getAdx(List<KLineDataModel> paramList, int paramInt) {
        ArrayList localArrayList = new ArrayList();
        int i = paramList.size();
        double[] arrayOfDouble1 = new double[i];
        double[] arrayOfDouble2 = new double[i];
        double[] arrayOfDouble3 = new double[i];
        String[] arrayOfString = new String[i];
        for (int j = 0; j < i; j++) {
            KLineDataModel localKLineData = (KLineDataModel) paramList.get(j);
            arrayOfDouble1[j] = localKLineData.close;
            arrayOfDouble2[j] = localKLineData.high;
            arrayOfDouble3[j] = localKLineData.low;
            arrayOfString[j] = localKLineData.date;
        }
        Core localCore = new Core();
        MInteger localMInteger1 = new MInteger();
        MInteger localMInteger2 = new MInteger();
        double[] arrayOfDouble4 = new double[arrayOfDouble1.length];
        RetCode localRetCode1 = localCore.adx(0, -1 + arrayOfDouble1.length, arrayOfDouble2, arrayOfDouble3, arrayOfDouble1, paramInt, localMInteger1, localMInteger2, arrayOfDouble4);
        double[] arrayOfDouble5 = new double[arrayOfDouble1.length];
        for (int k = 0; k < localMInteger2.value; k++) {
            arrayOfDouble5[(k + localMInteger1.value)] = arrayOfDouble4[k];
        }
        RetCode localRetCode2 = RetCode.Success;
        int m = 0;
        if (localRetCode2 == localRetCode1) {
            while (m < arrayOfDouble5.length) {
                ADX localADX = new ADX();
                localADX.date = arrayOfString[m];
                localADX.adx = getDoubleFloat(arrayOfDouble5[m]);
                localArrayList.add(localADX);
                m++;
            }
        }
        return localArrayList;
    }

    public static List<ATR> getAtr(List<KLineDataModel> paramList, int paramInt) {
        ArrayList localArrayList = new ArrayList();
        int i = paramList.size();
        double[] arrayOfDouble1 = new double[i];
        double[] arrayOfDouble2 = new double[i];
        double[] arrayOfDouble3 = new double[i];
        String[] arrayOfString = new String[i];
        for (int j = 0; j < i; j++) {
            KLineDataModel localKLineData = (KLineDataModel) paramList.get(j);
            arrayOfDouble1[j] = localKLineData.close;
            arrayOfDouble2[j] = localKLineData.high;
            arrayOfDouble3[j] = localKLineData.low;
            arrayOfString[j] = localKLineData.date;
        }
        Core localCore = new Core();
        MInteger localMInteger1 = new MInteger();
        MInteger localMInteger2 = new MInteger();
        double[] arrayOfDouble4 = new double[arrayOfDouble1.length];
        RetCode localRetCode1 = localCore.atr(0, -1 + arrayOfDouble1.length, arrayOfDouble2, arrayOfDouble3, arrayOfDouble1, paramInt, localMInteger1, localMInteger2, arrayOfDouble4);
        double[] arrayOfDouble5 = new double[arrayOfDouble1.length];
        for (int k = 0; k < localMInteger2.value; k++) {
            arrayOfDouble5[(k + localMInteger1.value)] = arrayOfDouble4[k];
        }
        RetCode localRetCode2 = RetCode.Success;
        int m = 0;
        if (localRetCode2 == localRetCode1) {
            while (m < arrayOfDouble5.length) {
                ATR localATR = new ATR();
                localATR.date = arrayOfString[m];
                localATR.atr = getDoubleFloat(arrayOfDouble5[m]);
                localArrayList.add(localATR);
                m++;
            }
        }
        return localArrayList;
    }

    public static float getDecimal(double paramDouble, int paramInt) {
        if ((!Double.isNaN(paramDouble)) && (paramDouble != 0.0D)) {
            return (float) new BigDecimal(paramDouble).setScale(paramInt, 4).floatValue();
        }
        return (0.0F / 0.0F);
    }

    public static float getDoubleFloat(double paramDouble) {
        if ((!Double.isNaN(paramDouble)) && (paramDouble != 0.0D)) {
            return (float) paramDouble;
        }
        return (0.0F / 0.0F);
    }

    public static List<KDJ> getKDJ(List<KLineDataModel> paramList, int paramInt1,
                                   int paramInt2, int paramInt3) {
        ArrayList localArrayList = new ArrayList();
        int i = paramList.size();
        double[] arrayOfDouble1 = new double[i];
        double[] arrayOfDouble2 = new double[i];
        double[] arrayOfDouble3 = new double[i];
        String[] arrayOfString = new String[i];
        for (int j = 0; j < i; j++) {
            KLineDataModel localKLineData = (KLineDataModel) paramList.get(j);
            arrayOfDouble1[j] = localKLineData.close;
            arrayOfDouble2[j] = localKLineData.high;
            arrayOfDouble3[j] = localKLineData.low;
            arrayOfString[j] = localKLineData.date


            ;
        }
        Core localCore = new Core();
        MInteger localMInteger1 = new MInteger();
        MInteger localMInteger2 = new MInteger();
        double[] arrayOfDouble4 = new double[arrayOfDouble1.length];
        double[] arrayOfDouble5 = new double[arrayOfDouble1.length];
        RetCode localRetCode = localCore.stoch(0, -1 + arrayOfDouble1.length, arrayOfDouble2, arrayOfDouble3, arrayOfDouble1, paramInt1, paramInt2, MAType.Ema, paramInt3, MAType.Ema, localMInteger1, localMInteger2, arrayOfDouble4, arrayOfDouble5);
        double[] arrayOfDouble6 = new double[arrayOfDouble1.length];
        for (int k = 0; k < localMInteger2.value; k++) {
            arrayOfDouble6[(k + localMInteger1.value)] = arrayOfDouble4[k];
        }
        double[] arrayOfDouble7 = new double[arrayOfDouble1.length];
        for (int m = 0; m < localMInteger2.value; m++) {
            arrayOfDouble7[(m + localMInteger1.value)] = arrayOfDouble5[m];
        }
        if (RetCode.Success == localRetCode) {
            for (int n = 0; n < arrayOfDouble6.length; n++) {
                KDJ localKDJ = new KDJ();
                localKDJ.k = getDoubleFloat(arrayOfDouble6[n]);
                localKDJ.d = getDoubleFloat(arrayOfDouble7[n]);
                localKDJ.j = getDoubleFloat(3.0D * arrayOfDouble6[n] - 2.0D * arrayOfDouble7[n]);
                localKDJ.date = arrayOfString[n];
                localArrayList.add(localKDJ);
            }
        }
        return localArrayList;
    }

    public static List<MACD> getMACD(List<KLineDataModel> paramList, int paramInt1,
                                     int paramInt2, int paramInt3) {
        ArrayList localArrayList = new ArrayList();
        int i = paramList.size();
        double[] arrayOfDouble1 = new double[i];
        String[] arrayOfString = new String[i];
        for (int j = 0; j < i; j++) {
            KLineDataModel localKLineData = (KLineDataModel) paramList.get(j);
            arrayOfDouble1[j] = localKLineData.close;
            arrayOfString[j] = localKLineData.date;
        }
        Core localCore = new Core();
        MInteger localMInteger1 = new MInteger();
        MInteger localMInteger2 = new MInteger();
        double[] arrayOfDouble2 = new double[arrayOfDouble1.length];
        double[] arrayOfDouble3 = new double[arrayOfDouble1.length];
        double[] arrayOfDouble4 = new double[arrayOfDouble1.length];
        RetCode localRetCode = localCore.macd(0, -1 + arrayOfDouble1.length, arrayOfDouble1, paramInt1, paramInt2, paramInt3, localMInteger1, localMInteger2, arrayOfDouble2, arrayOfDouble3, arrayOfDouble4);
        if (RetCode.Success == localRetCode) {
            double[] arrayOfDouble5 = new double[arrayOfDouble1.length];
            double[] arrayOfDouble6 = new double[arrayOfDouble1.length];
            double[] arrayOfDouble7 = new double[arrayOfDouble1.length];
            for (int k = 0; k < localMInteger2.value; k++) {
                arrayOfDouble5[(k + localMInteger1.value)] = arrayOfDouble2[k];
                arrayOfDouble6[(k + localMInteger1.value)] = arrayOfDouble3[k];
                arrayOfDouble7[(k + localMInteger1.value)] = arrayOfDouble4[k];
            }
            for (int m = 0; m < arrayOfDouble5.length; m++) {
                MACD localMACD = new MACD();
                localMACD.date = arrayOfString[m];
                localMACD.dea = (getDecimal((float) (1000000.0D * arrayOfDouble6[m]), 4) / 1000000.0F);
                localMACD.dif = (getDecimal((float) (1000000.0D * arrayOfDouble5[m]), 4) / 1000000.0F);
                localMACD.macd = (getDecimal((float) (1000000.0D * (2.0D * arrayOfDouble7[m])), 4) / 1000000.0F);
                localArrayList.add(localMACD);
            }
        }
        return localArrayList;
    }

    public static List<KLineDataModel> getMaBOLL(List<KLineDataModel> paramList, int paramInt1,
                                                 int paramInt2) {
        int i = paramList.size();
        double[] arrayOfDouble1 = new double[i];
        String[] arrayOfString = new String[i];
        for (int j = 0; j < i; j++) {
            KLineDataModel localKLineData = (KLineDataModel) paramList.get(j);
            arrayOfDouble1[j] = localKLineData.close;
            arrayOfString[j] = localKLineData.date;
        }
        Core localCore = new Core();
        MInteger localMInteger1 = new MInteger();
        MInteger localMInteger2 = new MInteger();
        double[] arrayOfDouble2 = new double[arrayOfDouble1.length];
        double[] arrayOfDouble3 = new double[arrayOfDouble1.length];
        double[] arrayOfDouble4 = new double[arrayOfDouble1.length];
        int k = -1 + arrayOfDouble1.length;
        double d = paramInt2;
        RetCode localRetCode = localCore.bbands(0, k, arrayOfDouble1, paramInt1, d, d, MAType.Sma, localMInteger1, localMInteger2, arrayOfDouble2, arrayOfDouble3, arrayOfDouble4);
        if (RetCode.Success == localRetCode) {
            double[] arrayOfDouble5 = new double[arrayOfDouble1.length];
            double[] arrayOfDouble6 = new double[arrayOfDouble1.length];
            double[] arrayOfDouble7 = new double[arrayOfDouble1.length];
            for (int m = 0; m < localMInteger2.value; m++) {
                arrayOfDouble5[(m + localMInteger1.value)] = arrayOfDouble2[m];
                arrayOfDouble6[(m + localMInteger1.value)] = arrayOfDouble3[m];
                arrayOfDouble7[(m + localMInteger1.value)] = arrayOfDouble4[m];
            }
            for (int n = 0; n < arrayOfDouble5.length; n++) {
                ((KLineDataModel) paramList.get(n)).maUp = getDoubleFloat(arrayOfDouble5[n]);
                ((KLineDataModel) paramList.get(n)).maMid = getDoubleFloat(arrayOfDouble6[n]);
                ((KLineDataModel) paramList.get(n)).maLow = getDoubleFloat(arrayOfDouble7[n]);
            }
        }
        return paramList;
    }

    public static List<RSI> getRsi(List<KLineDataModel> paramList, int paramInt) {
        ArrayList localArrayList = new ArrayList();
        int i = paramList.size();
        double[] arrayOfDouble1 = new double[i];
        String[] arrayOfString = new String[i];
        for (int j = 0; j < i; j++) {
            KLineDataModel localKLineData = (KLineDataModel) paramList.get(j);
            arrayOfDouble1[j] = localKLineData.close;
            arrayOfString[j] = localKLineData.date;
        }
        Core localCore = new Core();
        MInteger localMInteger1 = new MInteger();
        MInteger localMInteger2 = new MInteger();
        double[] arrayOfDouble2 = new double[arrayOfDouble1.length];
        RetCode localRetCode1 = localCore.rsi(0, -1 + arrayOfDouble1.length, arrayOfDouble1, paramInt, localMInteger1, localMInteger2, arrayOfDouble2);
        double[] arrayOfDouble3 = new double[arrayOfDouble1.length];
        for (int k = 0; k < localMInteger2.value; k++) {
            arrayOfDouble3[(k + localMInteger1.value)] = arrayOfDouble2[k];
        }
        RetCode localRetCode2 = RetCode.Success;
        int m = 0;
        if (localRetCode2 == localRetCode1) {
            while (m < arrayOfDouble3.length) {
                RSI localRSI = new RSI();
                localRSI.date = arrayOfString[m];
                localRSI.rsi1 = getDoubleFloat(arrayOfDouble3[m]);
                localArrayList.add(localRSI);
                m++;
            }
        }
        return localArrayList;
    }

    public static List<RSI> getRsi(List<KLineDataModel> paramList, int paramInt1,
                                   int paramInt2, int paramInt3) {
        ArrayList localArrayList = new ArrayList();
        int i = paramList.size();
        double[] arrayOfDouble1 = new double[i];
        String[] arrayOfString = new String[i];
        for (int j = 0; j < i; j++) {
            KLineDataModel localKLineData = (KLineDataModel) paramList.get(j);
            arrayOfDouble1[j] = localKLineData.close;
            arrayOfString[j] = localKLineData.date;
        }
        Core localCore = new Core();
        MInteger localMInteger1 = new MInteger();
        MInteger localMInteger2 = new MInteger();
        MInteger localMInteger3 = new MInteger();
        MInteger localMInteger4 = new MInteger();
        MInteger localMInteger5 = new MInteger();
        MInteger localMInteger6 = new MInteger();
        double[] arrayOfDouble2 = new double[arrayOfDouble1.length];
        double[] arrayOfDouble3 = new double[arrayOfDouble1.length];
        double[] arrayOfDouble4 = new double[arrayOfDouble1.length];
        RetCode localRetCode1 = localCore.rsi(0, -1 + arrayOfDouble1.length, arrayOfDouble1, paramInt1, localMInteger1, localMInteger4, arrayOfDouble2);
        RetCode localRetCode2 = localCore.rsi(0, -1 + arrayOfDouble1.length, arrayOfDouble1, paramInt2, localMInteger2, localMInteger5, arrayOfDouble3);
        RetCode localRetCode3 = localCore.rsi(0, -1 + arrayOfDouble1.length, arrayOfDouble1, paramInt3, localMInteger3, localMInteger6, arrayOfDouble4);
        double[] arrayOfDouble5 = new double[arrayOfDouble1.length];
        double[] arrayOfDouble6 = new double[arrayOfDouble1.length];
        double[] arrayOfDouble7 = new double[arrayOfDouble1.length];
        for (int k = 0; k < localMInteger4.value; k++) {
            arrayOfDouble5[(k + localMInteger1.value)] = arrayOfDouble2[k];
        }
        for (int m = 0; m < localMInteger5.value; m++) {
            arrayOfDouble6[(m + localMInteger2.value)] = arrayOfDouble3[m];
        }
        for (int n = 0; n < localMInteger6.value; n++) {
            arrayOfDouble7[(n + localMInteger3.value)] = arrayOfDouble4[n];
        }
        if ((RetCode.Success == localRetCode1) && (RetCode.Success == localRetCode2) && (RetCode.Success == localRetCode3)) {
            for (int i1 = 0; i1 < arrayOfDouble5.length; i1++) {
                RSI localRSI = new RSI();
                localRSI.date = arrayOfString[i1];
                localRSI.rsi1 = getDoubleFloat(arrayOfDouble5[i1]);
                localRSI.rsi2 = getDoubleFloat(arrayOfDouble6[i1]);
                localRSI.rsi3 = getDoubleFloat(arrayOfDouble7[i1]);
                localArrayList.add(localRSI);
            }
        }
        return localArrayList;
    }

    public static ArrayList<KLineDataModel> getmovingAverage
            (ArrayList<KLineDataModel> paramArrayList, int paramInt1, int paramInt2, int paramInt3) {
        new ArrayList();
        int i = paramArrayList.size();
        double[] arrayOfDouble1 = new double[i];
        String[] arrayOfString = new String[i];
        for (int j = 0; j < i; j++) {
            KLineDataModel localKLineData = (KLineDataModel) paramArrayList.get(j);
            arrayOfString[j] = localKLineData.date;
            switch (paramInt1) {
                default:
                    break;
                case 4:
                    arrayOfDouble1[j] = localKLineData.low;
                    break;
                case 3:
                    arrayOfDouble1[j] = localKLineData.close;
                    break;
                case 1:
                    arrayOfDouble1[j] = localKLineData.high;
                    break;
                case 0:
                    arrayOfDouble1[j] = localKLineData.open;
                case 2:
            }
        }
        Core localCore = new Core();
        MInteger localMInteger1 = new MInteger();
        MInteger localMInteger2 = new MInteger();
        Object localObject = null;
        double[] arrayOfDouble2 = new double[arrayOfDouble1.length];
        double[] arrayOfDouble3;
        RetCode localRetCode1 = null;
        RetCode localRetCode2 = null;
        RetCode localRetCode5 = null;
        RetCode localRetCode4 = null;
        switch (paramInt2) {
            default:
                arrayOfDouble3 = arrayOfDouble2;
                break;
            case 3:
                if (paramInt3 == HqDefaultValue.MA1) {
                    int i2 = -1 + arrayOfDouble1.length;
                    int i3 = HqDefaultValue.MA1;
                    MAType localMAType = MAType.Trima;
                    arrayOfDouble3 = arrayOfDouble2;
                    localRetCode5 = localCore.movingAverage(0, i2, arrayOfDouble1, i3, localMAType, localMInteger1, localMInteger2, arrayOfDouble2);
                } else {
                    arrayOfDouble3 = arrayOfDouble2;
                    if (paramInt3 == HqDefaultValue.MA2) {
                        localRetCode1 = localCore.movingAverage(0, -1 + arrayOfDouble1.length, arrayOfDouble1, HqDefaultValue.MA2, MAType.Trima, localMInteger1, localMInteger2, arrayOfDouble3);
                        break;
                    }
                    if (paramInt3 != HqDefaultValue.MA3) {
                        break;
                    }
                    localRetCode4 = localCore.movingAverage(0, -1 + arrayOfDouble1.length, arrayOfDouble1, HqDefaultValue.MA3, MAType.Trima, localMInteger1, localMInteger2, arrayOfDouble3);
                }
                break;
            case 2:
                arrayOfDouble3 = arrayOfDouble2;
                if (paramInt3 == HqDefaultValue.MA1) {
                    localRetCode5 = localCore.movingAverage(0, -1 + arrayOfDouble1.length, arrayOfDouble1, HqDefaultValue.MA1, MAType.Wma, localMInteger1, localMInteger2, arrayOfDouble3);
                } else {
                    if (paramInt3 == HqDefaultValue.MA2) {
                        localRetCode1 = localCore.movingAverage(0, -1 + arrayOfDouble1.length, arrayOfDouble1, HqDefaultValue.MA2, MAType.Wma, localMInteger1, localMInteger2, arrayOfDouble3);
                        break;
                    }
                    if (paramInt3 != HqDefaultValue.MA3) {
                        break;
                    }
                    localRetCode4 = localCore.movingAverage(0, -1 + arrayOfDouble1.length, arrayOfDouble1, HqDefaultValue.MA3, MAType.Wma, localMInteger1, localMInteger2, arrayOfDouble3);
                }
                break;
            case 1:
                arrayOfDouble3 = arrayOfDouble2;
                if (paramInt3 == HqDefaultValue.MA1) {
                    localRetCode5 = localCore.movingAverage(0, -1 + arrayOfDouble1.length, arrayOfDouble1, HqDefaultValue.MA1, MAType.Ema, localMInteger1, localMInteger2, arrayOfDouble3);
                } else {
                    if (paramInt3 == HqDefaultValue.MA2) {
                        localRetCode1 = localCore.movingAverage(0, -1 + arrayOfDouble1.length, arrayOfDouble1, HqDefaultValue.MA2, MAType.Ema, localMInteger1, localMInteger2, arrayOfDouble3);
                        break;
                    }
                    if (paramInt3 != HqDefaultValue.MA3) {
                        break;
                    }
                    localRetCode4 = localCore.movingAverage(0, -1 + arrayOfDouble1.length, arrayOfDouble1, HqDefaultValue.MA3, MAType.Ema, localMInteger1, localMInteger2, arrayOfDouble3);
                }
                break;
            case 0:
                arrayOfDouble3 = arrayOfDouble2;
                if (paramInt3 != HqDefaultValue.MA1) {
                    break;
                }
                localRetCode5 = localCore.movingAverage(0, -1 + arrayOfDouble1.length, arrayOfDouble1, HqDefaultValue.MA1, MAType.Sma, localMInteger1, localMInteger2, arrayOfDouble3);
        }
        localObject = localRetCode5;

        if (paramInt3 == HqDefaultValue.MA2) {
            localRetCode1 = localCore.movingAverage(0, -1 + arrayOfDouble1.length, arrayOfDouble1, HqDefaultValue.MA2, MAType.Sma, localMInteger1, localMInteger2, arrayOfDouble3);

            localRetCode2 = null;
            localObject = null;
        } else if (paramInt3 == HqDefaultValue.MA3) {
            localRetCode4 = localCore.movingAverage(0, -1 + arrayOfDouble1.length, arrayOfDouble1, HqDefaultValue.MA3, MAType.Sma, localMInteger1, localMInteger2, arrayOfDouble3);
            localRetCode2 = localRetCode4;
            localRetCode1 = null;
            localObject = null;
        } else {
            localRetCode1 = null;
            localRetCode2 = null;
        }
        double[] arrayOfDouble4 = new double[arrayOfDouble1.length];
        for (int k = 0; k < localMInteger2.value; k++) {
            arrayOfDouble4[(k + localMInteger1.value)] = arrayOfDouble3[k];
        }
        if (RetCode.Success == localObject) {
            for (int i1 = 0; i1 < arrayOfDouble4.length; i1++) {
                if (arrayOfDouble4[i1] == 0.0D) {
                    continue;
                }
                ((KLineDataModel) paramArrayList.get(i1)).ma5=((float) arrayOfDouble4[i1]);
            }
        }
        if (RetCode.Success == localRetCode1) {
            for (int n = 0; n < arrayOfDouble4.length; n++) {
                if (arrayOfDouble4[n] == 0.0D) {
                    continue;
                }
                ((KLineDataModel) paramArrayList.get(n)).ma10=((float) arrayOfDouble4[n]);
            }
        }
        RetCode localRetCode3 = RetCode.Success;
        int m = 0;
        if (localRetCode3 == localRetCode2) {
            while (m < arrayOfDouble4.length) {
                if (arrayOfDouble4[m] != 0.0D) {
                    ((KLineDataModel) paramArrayList.get(m)).ma20=((float) arrayOfDouble4[m]);
                }
                m++;
            }
        }
        return paramArrayList;
    }
}
