cmake_minimum_required(VERSION 3.10)
project(WebApp C) # Specify C language for the project

set(CMAKE_C_STANDARD 99)

# Explicitly pass -sUSE_SDL=2 as a compile option.
# This ensures the compiler uses the correct SDL headers provided by Emscripten,
# preventing the "fakesdl" error.
target_compile_options(WebApp PRIVATE "-sUSE_SDL=2")

# Find SDL2 for Emscripten. Emscripten's toolchain file should handle this,
# and link against the correct Emscripten SDL library.
find_package(SDL2 REQUIRED)

add_executable(WebApp main.c)

# Link against the found SDL2. Emscripten's toolchain will handle the specific linker flags.
target_link_libraries(WebApp PRIVATE SDL2::SDL2)

# If you have assets to preload, you can add this line:
# target_link_options(WebApp PRIVATE "--preload-file assets")
