package com.example.loginapp.model

import android.os.Parcel
import android.os.Parcelable

data class Item(
    val imageSource: Int,
    val imageTitle: String,
    val imageDesc: String,
    val songResId: Int  // ➡️ Tambahan: untuk menyimpan id lagu
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()  // ➡️ Tambahkan ini
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imageSource)
        parcel.writeString(imageTitle)
        parcel.writeString(imageDesc)
        parcel.writeInt(songResId)  // ➡️ Tambahkan ini
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Item> {
        override fun createFromParcel(parcel: Parcel): Item = Item(parcel)
        override fun newArray(size: Int): Array<Item?> = arrayOfNulls(size)
    }
}
