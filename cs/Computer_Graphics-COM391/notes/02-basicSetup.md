## Basic Setup

1. update your graphics drivers
1. install [`python 3`][2], [`Visual Studio`][4] (or another IDE), [`cmake`][5] -- add `python3` to the path
1. install [`conan`][3] by running `pip3 install conan` in a shell
1. create a directory (named after your project, e.g. `lab01`) and navigate to it, create a directory called `build`
1. create `conanfile.txt` and add the following text:
    ```cpp
    [requires]
    sdl2/2.0.10@bincrafters/stable
    glew/2.1.0@bincrafters/stable
    [generators]
    cmake
    ```
3. create `CMakeLists.txt`, add this text (change _lab01_ to your project name):
    ```cpp
    cmake_minimum_required(VERSION "2.8.0")
    project("lab01")
    add_definitions("-std=c++11")
    include(${CMAKE_BINARY_DIR}/conanbuildinfo.cmake)
    conan_basic_setup()
    add_executable(lab01 lab01.cpp)
    target_link_libraries(lab01 ${CONAN_LIBS})
    ```
4. create `lab01.cpp` (must use same name as in `CMakeLists.txt`), add this code:
    ```cpp
    #include <GL/glew.h>
    #include <SDL.h>
    #include <SDL_opengl.h>
    int main(int argc, char **argv) {
        static const int WINDOW_WIDTH = 500;
        static const int WINDOW_HEIGHT = 500;
        // SDL setup
        SDL_Init(SDL_INIT_VIDEO);
        SDL_Window *window = SDL_CreateWindow("lab01", SDL_WINDOWPOS_CENTERED, 
            SDL_WINDOWPOS_CENTERED, WINDOW_WIDTH, WINDOW_HEIGHT, SDL_WINDOW_OPENGL);
        SDL_GLContext gl_context = SDL_GL_CreateContext(window);
        glewExperimental = GL_TRUE;
        glewInit();
        SDL_GL_SetSwapInterval(1);
        // SDL event handling
        for (;;) {
            SDL_Event event;
            while (SDL_PollEvent(&event)) {
                if (event.type == SDL_QUIT) { goto end; }
            }
        }
    end:
        // SDL shutdown - opposite order of setup
        SDL_GL_DeleteContext(gl_context);
        SDL_DestroyWindow(window);
        SDL_Quit();
        return 0;
    }
    ```
5. run `conan remote add bincrafters "https://api.bintray.com/conan/bincrafters/public-conan"` in a shell ([source][1] under 'Add Remote')
6. navigate to the `build` directory
6. _Mac OS:_ run `conan install ..`       
_Windows:_ run `conan install .. --build glew -s build_type=Debug`
7. _Mac OS:_ run `cmake`      
_Windows:_ use the CMake gui to set the `Where is the source` to your main project folder
and `Where to build the binaries` to the `build` folder, click `Configure` and
select `Visual Studio` (the version you have installed), click `Generate`, and
finally `Open Project`
8. _Mac OS:_ run `make`, then `./bin/lab01` to start the program      
_Windows:_ in the sidebar of Visual Studio, navigate to your `.cpp` file in
your directory, open it, click `Local Windows Debugger` in the top bar to
execute


[1]: https://github.com/bincrafters/conan-sdl2
[2]: https://www.python.org/
[3]: https://conan.io/downloads.html
[4]: https://visualstudio.microsoft.com/free-developer-offers/
[5]: https://cmake.org/download/
