#import "CamerabiosdkPlugin.h"
#if __has_include(<camerabiosdk/camerabiosdk-Swift.h>)
#import <camerabiosdk/camerabiosdk-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "camerabiosdk-Swift.h"
#endif

@implementation CamerabiosdkPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftCamerabiosdkPlugin registerWithRegistrar:registrar];
}
@end
