cmake_minimum_required(VERSION 3.10)
project(AndroidApp C) # Specify C language for the project

# Add your native source file(s) to create a shared library
# The name here ('main') will result in libmain.so
add_library(main SHARED main.c)

# Find standard Android NDK libraries
find_library(log-lib log)
find_library(android-lib android)

# --- IMPORTANT: Find and Link SDL2 for Android ---
# This assumes libSDL2.so is available in the Android NDK's search paths,
# typically because it's included as a prebuilt library (e.g., in jniLibs)
# or provided by the SDL Android build system.
find_library(SDL2_LIBRARY SDL2)

# If SDL2_LIBRARY is not found, you might need to add specific paths.
# For example, if you manually place libSDL2.so in 'android/app/src/main/jniLibs/armeabi-v7a/':
# set(SDL2_LIBRARY "${CMAKE_CURRENT_SOURCE_DIR}/../jniLibs/${ANDROID_ABI}/libSDL2.so")
# Or, if SDL2 headers are also not found during compilation, you might need:
# include_directories("${CMAKE_CURRENT_SOURCE_DIR}/path/to/SDL_headers")


# Link all necessary libraries to your 'main' shared library
target_link_libraries(main
    ${log-lib}
    ${android-lib}
    ${SDL2_LIBRARY} # Link against the found SDL2 library
)

# For SDL Android, you often need to ensure the correct include paths for SDL.
# The SDLActivity setup usually handles this, but if you get compilation errors
# about missing SDL headers, you might need to add:
# include_directories(
#    ${CMAKE_CURRENT_SOURCE_DIR}/path/to/sdl_headers # e.g., if you copied SDL headers
# )
