package tv.airtel.stb.util

import tv.accedo.airtel.wynk.domain.interactor.DoMultipleContentRequest

/**
 * Created by VipulKumar on 1/16/18.
 *
 */
object DataUtil {
    private val multipleContentIds = "ATV_PACKAGE_1507636516333,ATV_PACKAGE_1510130437317,ATV_PACKAGE_1507545117635," +
            "ATV_PACKAGE_1507550400733,ATV_PACKAGE_1507359971188,ATV_PACKAGE_1507193345716," +
            "ATV_PACKAGE_1509705052435,ATV_PACKAGE_1508173887057,ATV_PACKAGE_1513663892870," +
            "ATV_PACKAGE_1507804892046,ATV_PACKAGE_1507659702278,ATV_PACKAGE_1507550793189," +
            "ATV_PACKAGE_1507721738231,ATV_PACKAGE_1507804812008,ATV_PACKAGE_1507544234817," +
            "ATV_PACKAGE_1507723173474,ATV_PACKAGE_1507726241578"

    fun getMultipleContentParams(): DoMultipleContentRequest.Params {
        return DoMultipleContentRequest.Params(multipleContentIds, false, false)
    }
}