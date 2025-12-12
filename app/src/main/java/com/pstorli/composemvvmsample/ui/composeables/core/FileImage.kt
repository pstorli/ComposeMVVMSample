package com.pstorli.composemvvmsample.ui.composeables.core

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.pstorli.composemvvmsample.util.Consts.debug

val ASSETS_DIR = "file:///android_asset"

/**
 * Get a composeable AssetImage from the assets dir.
 *
 * AS: file:///android_asset/folder/file
 *
 * @param assetsFolder
 * @param file
 * @param errorImage
 * @param modifier
 * @param contentScale
 * @param alignment
 *
 */
@Composable
fun Context.FileImage (assetsFolder: String, file: String, modifier: Modifier = Modifier, errorImage: Painter?=null, contentScale: ContentScale = ContentScale.Fit, alignment: Alignment = Alignment.Center)  {
    // Create a path. "file:///android_asset/race/name/correctEmotion.png"
    FileImage (path = createAssetsPath (assetsFolder, file), errorImage=errorImage, modifier = modifier, contentScale = contentScale, alignment = alignment)
}

/**
 * Get a composeable AssetImage from the assets dir.
 * We want all images to be the same size.
 *
 * @param path
 * @param errorImage
 * @param modifier
 * @param contentScale
 * @param alignment
 *
 */
@Composable
fun Context.FileImage (path: String, modifier: Modifier = Modifier, errorImage: Painter?=null, contentScale: ContentScale = ContentScale.FillBounds, alignment: Alignment = Alignment.Center)  {
    debug ("Context.FileImage: $path")
    if (null != errorImage) {
        // Fetch from path with placeholder
        AsyncImage(
            model = path,
            modifier = modifier,
            contentScale = contentScale,
            alignment = alignment,
            contentDescription = path,
            placeholder = errorImage,
            error = errorImage
        )
    } else {
        // Fetch from path.
        AsyncImage(
            model = path,
            modifier = modifier,
            contentScale = contentScale,
            alignment = alignment,
            contentDescription = path
        )
    }
}