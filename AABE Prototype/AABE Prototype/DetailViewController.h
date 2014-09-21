//
//  DetailViewController.h
//  AABE Prototype
//
//  Created by Rafagan Abreu on 17/07/14.
//  Copyright (c) 2014 Rafagan Abreu. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface DetailViewController : UIViewController <UISplitViewControllerDelegate>

@property (strong, nonatomic) id detailItem;

@property (weak, nonatomic) IBOutlet UILabel *detailDescriptionLabel;
@end
