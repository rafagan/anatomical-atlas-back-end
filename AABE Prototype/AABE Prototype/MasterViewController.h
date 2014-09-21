//
//  MasterViewController.h
//  AABE Prototype
//
//  Created by Rafagan Abreu on 17/07/14.
//  Copyright (c) 2014 Rafagan Abreu. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <RestKit/RestKit.h>

#define kCLIENTID @"Your Foursquare Client ID"
#define kCLIENTSECRET @"Your Foursquare Client Secret"

@class DetailViewController;

@interface MasterViewController : UITableViewController

@property (strong, nonatomic) DetailViewController *detailViewController;

@end
