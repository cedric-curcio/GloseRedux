package cedric.gloseapplication.common.domain.redux

import java.io.Serializable

import cedric.gloseapplication.gallery.domain.redux.GalleryState

/**
 * Created by cedric on 29/03/2017.
 */
class AppState : Serializable {
    // Sub-States
    var mGalleryState: GalleryState

    constructor() {
        mGalleryState = GalleryState()
    }

    constructor(galleryState: GalleryState) {
        mGalleryState = galleryState
    }
}
