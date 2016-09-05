'use strict';
var mountFolder = function (connect, dir) {
    return connect.static(require('path').resolve(dir));
};
var modRewrite = require('connect-modrewrite');
var proxySnippet = require('grunt-connect-proxy/lib/utils').proxyRequest;

module.exports = function (grunt) {
    // load all grunt tasks
    require('matchdep').filterDev('grunt-*').forEach(grunt.loadNpmTasks);

    // configurable paths
    var yeomanConfig = {
        app: 'src/main/webapp-components/application',
        dist: 'src/main/webapp-dist'
    };

    grunt.initConfig({
        yeoman: yeomanConfig,
        watch: {
            less: {
                options: {
                    livereload: {
                        port: 9000,
                        hostname: 'localhost'
                    }
                },
                files: [ '<%= yeoman.app %>/styles/*.less' ],
                tasks: ['less']
            },
            all: {
                options: {
                    livereload: {
                        port: 9000,
                        hostname: 'localhost'
                    }
                },
                files: [
                    '<%= yeoman.app %>/{,*/}*.html',
                    '<%= yeoman.app %>/modules{,*/}*.html',
                    '{.tmp,<%= yeoman.app %>}/styles/{,*/}*.css',
                    '<%= yeoman.app %>/modules/{,*/}*.js',
                    '<%= yeoman.app %>/images/{,*/}*.{png,jpg,jpeg,gif,webp,svg}'
                ]
            },
            livereload: {
                files: [
                    '<%= yeoman.app %>/{,*/}*.html',
                    '<%= yeoman.app %>/modules{,*/}*.html',
                    '{.tmp,<%= yeoman.app %>}/styles/{,*/}*.css',
                    '<%= yeoman.app %>/modules/{,*/}*.js',
                    '<%= yeoman.app %>/images/{,*/}*.{png,jpg,jpeg,gif,webp,svg}'
                ],
                options: { livereload: true }
            }
        },
        connect: {
            proxies: [
                {
                    context: '/server',
                    host: 'localhost',
                    port: 8080,
                    https: false,
                    changeOrigin: false,
                    ws: true
                }

            ],
            livereload: {
                options: {
                    middleware: function (connect) {
                        return [
                            proxySnippet,
                            modRewrite([
                                '!^/components(.*)|^/images(.*)|^/modules(.*)|^/styles(.*)|\\.ico /index.html'
                            ]),
                            mountFolder(connect, '.tmp'),
                            mountFolder(connect, yeomanConfig.app)
                        ];
                    }
                }
            },
            options: {
                port: 9000,
                // Change this to '0.0.0.0' to access the server from outside.
                hostname: 'localhost',
                ws: true
            },
            test: {
                options: {
                    middleware: function (connect) {
                        return [
                            mountFolder(connect, '.tmp'),
                            mountFolder(connect, 'test')
                        ];
                    }
                }
            }
        },
        open: {
            server: {
                url: 'http://localhost:<%= connect.options.port %>'
            }
        },
        clean: {
            dist: {
                files: [
                    {
                        dot: true,
                        src: [
                            '.tmp',
                            '<%= yeoman.dist %>/*',
                            '!<%= yeoman.dist %>/.git*'
                        ]
                    }
                ]
            },
            server: '.tmp'
        },
        less: {
            dist: {
                options: {
                    paths: [
                        "<%= yeoman.app %>/styles",
                        "<%= yeoman.app %>/components/bootstrap/less",
                        "<%= yeoman.app %>/components/font-awesome/less"
                    ]
                },
                files: {
                    ".tmp/styles/application.css": "<%= yeoman.app %>/styles/application.less"
                }
            }
        },
        concat: {
            js: {
                src: [
                    '.tmp/scripts/{,*/}*.js',
                    '<%= yeoman.app %>/modules/{,*/}*.js'
                ],
                dest: '<%= yeoman.dist %>/scripts/scripts.js'
            }
        },
        useminPrepare: {
            html: '<%= yeoman.app %>/index.html',
            options: {
                dest: '<%= yeoman.dist %>'
            }
        },
        usemin: {
            html: ['<%= yeoman.dist %>/modules/{,*/}*.html', '<%= yeoman.dist %>/{,*/}*.html'],
            css: ['<%= yeoman.dist %>/styles/{,*/}*.css'],
            options: {
                dirs: ['<%= yeoman.dist %>'],
                basedir: '<%= yeoman.dist %>'
            }
        },
        cssmin: {
            dist: {
                files: {
                    '<%= yeoman.dist %>/styles/main.css': [
                        '<%= yeoman.app %>/styles/{,*/}*.css'
                    ]
                }
            }
        },
        htmlmin: {
            dist: {
                files: [
                    {
                        expand: true,
                        cwd: '<%= yeoman.app %>',
                        src: ['*.html', 'modules/**/*.html'],
                        dest: '<%= yeoman.dist %>'
                    }
                ]
            }
        },
        rev: {
            dist: {
                files: {
                    src: [
                        '<%= yeoman.dist %>/scripts/{,*/}*.js',
                        '<%= yeoman.dist %>/styles/{,*/}*.css',
                        '<%= yeoman.dist %>/images/{,*/}*.{png,jpg,jpeg,gif,webp}',
                        '<%= yeoman.dist %>/styles/fonts/*'
                    ]
                }
            }
        },
        copy: {
            dist: {
                files: [
                    {
                        expand: true,
                        dot: true,
                        cwd: '<%= yeoman.app %>',
                        dest: '<%= yeoman.dist %>',
                        src: [
                            '*.{ico,txt}',
                            'components/**/*',
                            'images/{,*/}*.{gif,webp}',
                            'images/{,*/}*.{png,jpg,jpeg}',
                            '{,*/}*.html',
                            'styles/{,*/}*.css',
                            'modules/**/*.html'
                        ]
                    }
                ]
            }
        }
    });

    grunt.registerTask('server', [
        'clean:server',
        'less',
        'configureProxies',
        'connect:livereload',
        'open',
        'watch'
    ]);

    grunt.registerTask('build', [
        'clean:dist',
        'less',
        'useminPrepare',
        'cssmin',
        'concat',
        'copy',
        'rev',
        'usemin'
    ]);

    grunt.registerTask('default', ['build']);
};
