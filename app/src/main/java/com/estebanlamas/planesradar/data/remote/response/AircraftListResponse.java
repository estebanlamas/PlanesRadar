
package com.estebanlamas.planesradar.data.remote.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AircraftListResponse {

    @SerializedName("acList")
    private List<AircraftResponse> mAircraftResponse;
    @SerializedName("flgH")
    private Long mFlgH;
    @SerializedName("flgW")
    private Long mFlgW;
    @SerializedName("lastDv")
    private String mLastDv;
    @SerializedName("showFlg")
    private Boolean mShowFlg;
    @SerializedName("showPic")
    private Boolean mShowPic;
    @SerializedName("showSil")
    private Boolean mShowSil;
    @SerializedName("shtTrlSec")
    private Long mShtTrlSec;
    @SerializedName("src")
    private Long mSrc;
    @SerializedName("srcFeed")
    private Long mSrcFeed;
    @SerializedName("stm")
    private Long mStm;
    @SerializedName("totalAc")
    private Long mTotalAc;

    public List<AircraftResponse> getAcList() {
        return mAircraftResponse;
    }

    public void setAcList(List<AircraftResponse> aircraftResponse) {
        mAircraftResponse = aircraftResponse;
    }

    public Long getFlgH() {
        return mFlgH;
    }

    public void setFlgH(Long flgH) {
        mFlgH = flgH;
    }

    public Long getFlgW() {
        return mFlgW;
    }

    public void setFlgW(Long flgW) {
        mFlgW = flgW;
    }

    public String getLastDv() {
        return mLastDv;
    }

    public void setLastDv(String lastDv) {
        mLastDv = lastDv;
    }

    public Boolean getShowFlg() {
        return mShowFlg;
    }

    public void setShowFlg(Boolean showFlg) {
        mShowFlg = showFlg;
    }

    public Boolean getShowPic() {
        return mShowPic;
    }

    public void setShowPic(Boolean showPic) {
        mShowPic = showPic;
    }

    public Boolean getShowSil() {
        return mShowSil;
    }

    public void setShowSil(Boolean showSil) {
        mShowSil = showSil;
    }

    public Long getShtTrlSec() {
        return mShtTrlSec;
    }

    public void setShtTrlSec(Long shtTrlSec) {
        mShtTrlSec = shtTrlSec;
    }

    public Long getSrc() {
        return mSrc;
    }

    public void setSrc(Long src) {
        mSrc = src;
    }

    public Long getSrcFeed() {
        return mSrcFeed;
    }

    public void setSrcFeed(Long srcFeed) {
        mSrcFeed = srcFeed;
    }

    public Long getStm() {
        return mStm;
    }

    public void setStm(Long stm) {
        mStm = stm;
    }

    public Long getTotalAc() {
        return mTotalAc;
    }

    public void setTotalAc(Long totalAc) {
        mTotalAc = totalAc;
    }

}
