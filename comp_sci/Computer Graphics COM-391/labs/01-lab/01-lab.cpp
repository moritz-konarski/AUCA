#include <GL/glew.h>
#include <SDL.h>
#include <SDL_opengl.h>

#define HEIGHT  500
#define WIDTH   500

int main(int argc, char **argv) {

    // Initialization
    SDL_Init(SDL_INI_VIDEO);
    SDL_Window *window = SDL_CreateWindow("01-lab", SDL_WINDOW_POS_CENTERED, SDL_WINDOW_CENTERED, HEIGHT, WIDTH, SDL_WINDOW_OPENGL);
    SDL_GLContext gl_context = SDL_GL_CreateContext(window);
    glewExperimental = GL_TRUE;
    glewInit();
    SDL_GL_SetSwapInterval(1);
    
    // SDL Event Handling
    for (;;) {
        SDL_Event event;
        while (SDL_PollEvent(&event)) {
            if (event.type == SDL_QUIT) { goto end; }
    }

end:
    // SDL Shutdown
    SDL_DeleteContext(gl_context);
    SDL_DestroyWindow(window);
    SDL_Quit();

    return 0;
}

